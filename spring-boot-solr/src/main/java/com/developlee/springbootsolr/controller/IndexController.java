package com.developlee.springbootsolr.controller;

import com.developlee.springbootsolr.domain.Item;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liululee
 * @desc
 * @since 7/4/2019
 **/
@RestController
public class IndexController {

    @Autowired
    private SolrClient solrClient;

    /**
     * 每个item的Id必须唯一，插入重复id会更新该id的document
     */
    @PostMapping("/add")
    public void add(@RequestBody Item item) throws IOException, SolrServerException {
//        SolrInputDocument document = new SolrInputDocument();
//        document.addField("id", "123456");
//        document.addField("description", "This is Description!");
//        document.addField("category", "Books");
//        document.addField("price", "12.0");
//        solrClient.add(document);
//        solrClient.commit();

        // 使用bean 就可以不用上面的写法 &  once we have bean
        solrClient.addBean(item);
        solrClient.commit();
    }

    @GetMapping("/query")
    public List query() throws IOException, SolrServerException {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery("brand");
        solrQuery.setStart(0);
        solrQuery.setRows(1);
        QueryResponse queryResponse = solrClient.query(solrQuery);
        List<Item> itemList = queryResponse.getBeans(Item.class);
        return itemList;
    }

    @GetMapping("/getById/{id}")
    public List getById(@PathVariable String id) throws IOException, SolrServerException {
        //根据id查询内容
        SolrDocument solrDocument = solrClient.getById(id);
        //获取filedName
        Collection<String> fieldNames = solrDocument.getFieldNames();
        //获取file名和内容
        Map<String, Object> fieldValueMap = solrDocument.getFieldValueMap();

        List<SolrDocument> childDocuments = solrDocument.getChildDocuments();
        return childDocuments;
    }


    /**
     * 简单查询方式
     * @throws IOException
     * @throws SolrServerException
     */
    @GetMapping("/solrQuery")
    public SolrDocumentList solrClientSearch() throws IOException, SolrServerException {
        //第一种方式
        Map<String, String> queryParamMap = new HashMap<String, String>();
        queryParamMap.put("q", "*:*");
        queryParamMap.put("f1","id,name");
        queryParamMap.put("sort","id asc");
        MapSolrParams mapSolrParams = new MapSolrParams(queryParamMap);
        QueryResponse response = solrClient.query(mapSolrParams);
        return response.getResults();
    }

    /**
     * 第二种方式 查询
     */
    @GetMapping("/solrSearch")
    public List solrSearch() throws IOException, SolrServerException {
        SolrQuery solrQuery  = new SolrQuery();
        solrQuery.setQuery("*:*");
//        solrQuery.addField("*");
        solrQuery.add("q","id:4567");

        solrQuery.setSort("id", SolrQuery.ORDER.asc);
        //设置查询的条数
        solrQuery.setRows(50);
        //设置查询的开始
        solrQuery.setStart(0);
        //设置高亮
        solrQuery.setHighlight(true);
        //设置高亮的字段
        solrQuery.addHighlightField("item_name");
        //设置高亮的样式
        solrQuery.setHighlightSimplePre("<font color='red'>");
        solrQuery.setHighlightSimplePost("</font>");
        System.out.println(solrQuery);
        QueryResponse response = solrClient.query(solrQuery);
        //返回高亮显示结果
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
//        return (List) highlighting;
        //response.getResults();查询返回的结果
        SolrDocumentList documentList = response.getResults();
        for (SolrDocument solrDocument : documentList) {
            System.out.println("solrDocument==============" +solrDocument);
        }
        return documentList;
    }

    @GetMapping("/delete/{id}")
    public void deleteSolr(@PathVariable String id) throws IOException, SolrServerException {
        solrClient.deleteById(id);
        solrClient.commit();
    }
}

package com.developlee.springbootmessageconverter.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liululee
 * @desc
 * @since 2019/5/28 0028
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@JacksonXmlRootElement(localName = "message")
public class MessageEntity {
    @JacksonXmlProperty(localName = "name")
    private String name;

    @JacksonXmlProperty(localName = "msg")
    private String msg;

    @JacksonXmlProperty(localName = "code")
    private String code;
}

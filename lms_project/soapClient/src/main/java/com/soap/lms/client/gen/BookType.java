//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.24 at 10:37:49 PM TRT 
//


package com.soap.lms.client.gen;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bookType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="bookType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="biology"/&gt;
 *     &lt;enumeration value="physics"/&gt;
 *     &lt;enumeration value="mathematics"/&gt;
 *     &lt;enumeration value="social"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "bookType")
@XmlEnum
public enum BookType {

    @XmlEnumValue("biology")
    BIOLOGY("biology"),
    @XmlEnumValue("physics")
    PHYSICS("physics"),
    @XmlEnumValue("mathematics")
    MATHEMATICS("mathematics"),
    @XmlEnumValue("social")
    SOCIAL("social");
    private final String value;

    BookType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BookType fromValue(String v) {
        for (BookType c: BookType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

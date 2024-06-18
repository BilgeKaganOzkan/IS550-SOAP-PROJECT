//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.24 at 10:37:49 PM TRT 
//


package com.soap.lms.client.gen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for userBorrowingInfos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userBorrowingInfos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="book" type="{http://lms.soap.com}book"/&gt;
 *         &lt;element name="borrowingTime" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="returningTime" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="paid" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fine" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userBorrowingInfos", propOrder = {
    "book",
    "borrowingTime",
    "dueDate",
    "returningTime",
    "paid",
    "fine"
})
public class UserBorrowingInfos {

    @XmlElement(required = true)
    protected Book book;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar borrowingTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dueDate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar returningTime;
    @XmlElement(required = true)
    protected String paid;
    protected long fine;

    /**
     * Gets the value of the book property.
     * 
     * @return
     *     possible object is
     *     {@link Book }
     *     
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the value of the book property.
     * 
     * @param value
     *     allowed object is
     *     {@link Book }
     *     
     */
    public void setBook(Book value) {
        this.book = value;
    }

    /**
     * Gets the value of the borrowingTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBorrowingTime() {
        return borrowingTime;
    }

    /**
     * Sets the value of the borrowingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBorrowingTime(XMLGregorianCalendar value) {
        this.borrowingTime = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the returningTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReturningTime() {
        return returningTime;
    }

    /**
     * Sets the value of the returningTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReturningTime(XMLGregorianCalendar value) {
        this.returningTime = value;
    }

    /**
     * Gets the value of the paid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaid() {
        return paid;
    }

    /**
     * Sets the value of the paid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaid(String value) {
        this.paid = value;
    }

    /**
     * Gets the value of the fine property.
     * 
     */
    public long getFine() {
        return fine;
    }

    /**
     * Sets the value of the fine property.
     * 
     */
    public void setFine(long value) {
        this.fine = value;
    }

}
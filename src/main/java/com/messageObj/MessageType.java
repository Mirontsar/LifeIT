//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.06 at 02:36:34 AM MSK 
//


package com.messageObj;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/**
 * <p>Java class for messageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dispatched" type="{}dispatchedType"/>
 *         &lt;element name="target" type="{}targetType"/>
 *         &lt;element name="sometags" type="{}sometagsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "messageType", propOrder = {
    "dispatched",
    "target",
    "sometags"
})
public class MessageType {

    @XmlElement(required = true)
    protected DispatchedType dispatched;
    @XmlElement(required = true)
    protected TargetType target;
    @XmlElement(required = true)
    protected SometagsType sometags;

    /**
     * Gets the value of the dispatched property.
     * 
     * @return
     *     possible object is
     *     {@link DispatchedType }
     *     
     */
    public DispatchedType getDispatched() {
        return dispatched;
    }

    /**
     * Sets the value of the dispatched property.
     * 
     * @param value
     *     allowed object is
     *     {@link DispatchedType }
     *     
     */
    public void setDispatched(DispatchedType value) {
        this.dispatched = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link TargetType }
     *     
     */
    public TargetType getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetType }
     *     
     */
    public void setTarget(TargetType value) {
        this.target = value;
    }

    /**
     * Gets the value of the sometags property.
     * 
     * @return
     *     possible object is
     *     {@link SometagsType }
     *     
     */
    public SometagsType getSometags() {
        return sometags;
    }

    /**
     * Sets the value of the sometags property.
     * 
     * @param value
     *     allowed object is
     *     {@link SometagsType }
     *     
     */
    public void setSometags(SometagsType value) {
        this.sometags = value;
    }

    public static void getMsgObject(MessageType msg) throws JAXBException {
        //Создаем директорию и файлы для каждого исполнителя
        Integer numb = msg.getDispatched().getId();
        File dir = new File("C://Driver" + numb + "Folder");
        File newFile = new File("C://Driver" + numb + "Folder//Order_" + msg.getTarget().getId() + ".xml");
        boolean isDirExist = false;
        if (!dir.isDirectory()) {
            isDirExist = dir.mkdir();
            marshMessageToXml(msg, newFile);
        } else {
            marshMessageToXml(msg, newFile);
        }
    }

    private static void marshMessageToXml(MessageType msg, File newFile) throws JAXBException {
        try {
            newFile.createNewFile();
            JAXBContext context = JAXBContext.newInstance(MessageType.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(msg, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static MessageType getMessageTypeObj(Integer i) {
        MessageType msg = new MessageType();
        msg.setSometags(new SometagsType());
        msg.setTarget(new TargetType());
        msg.getTarget().setId(i);
        List<String> list = Arrays.asList("", "", "");
        msg.getSometags().setData(list);
        return msg;
    }

}

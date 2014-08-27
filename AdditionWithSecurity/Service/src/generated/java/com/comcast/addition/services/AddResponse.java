
package com.comcast.addition.services;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sum"
})
@XmlRootElement(name = "addResponse")
public class AddResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected int sum;

    /**
     * Gets the value of the sum property.
     * 
     */
    public int getSum() {
        return sum;
    }

    /**
     * Sets the value of the sum property.
     * 
     */
    public void setSum(int value) {
        this.sum = value;
    }

}

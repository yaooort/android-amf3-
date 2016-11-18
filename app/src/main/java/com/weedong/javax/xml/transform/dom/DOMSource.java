/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://jaxp.dev.java.net/CDDLv1.0.html.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * https://jaxp.dev.java.net/CDDLv1.0.html
 * If applicable add the following below this CDDL HEADER
 * with the fields enclosed by brackets "[]" replaced with
 * your own identifying information: Portions Copyright
 * [year] [name of copyright owner]
 */

/*
 * $Id: XMLEntityReader.java,v 1.3 2005/11/03 17:02:21 jeffsuttor Exp $
 * @(#)DOMSource.java	1.24 05/11/17
 *
 * Copyright 2006 Sun Microsystems, Inc. All Rights Reserved.
 */

package com.weedong.javax.xml.transform.dom;


import org.w3c.dom.Node;

import com.weedong.javax.xml.transform.Source;

/**
 * <p>Acts as a holder for a transformation Source tree in the
 * form of a Document Object Model (DOM) tree.</p>
 * 
 * <p>Note that XSLT requires namespace support. Attempting to transform a DOM
 * that was not contructed with a namespace-aware parser may result in errors.
 * Parsers can be made namespace aware by calling
 * {@link javax.xml.parsers.DocumentBuilderFactory#setNamespaceAware(boolean awareness)}.</p>
 * 
 * @author <a href="Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 1.2 $, $Date: 2005/06/10 03:50:40 $
 * @see <a href="http://www.w3.org/TR/DOM-Level-2">Document Object Model (DOM) Level 2 Specification</a>
 */
public class DOMSource implements Source {

    /**
     * <p><code>Node</code> to serve as DOM source.</p>
     */
    private Node node;

    /**
     * <p>The base ID (URL or system ID) from where URLs
     * will be resolved.</p>
     */
    private String systemID;

    /** If {@link com.weedong.javax.xml.transform.TransformerFactory#getFeature}
     * returns true when passed this value as an argument,
     * the Transformer supports Source input of this type.
     */
    public static final String FEATURE =
        "http://javax.xml.transform.dom.DOMSource/feature";

    /**
     * <p>Zero-argument default constructor.  If this constructor is used, and
     * no DOM source is set using {@link #setNode(Node node)} , then the
     * <code>Transformer</code> will
     * create an empty source {@link org.w3c.dom.Document} using
     * {@link javax.xml.parsers.DocumentBuilder#newDocument()}.</p>
     *
     * @see com.weedong.javax.xml.transform.Transformer#transform(Source xmlSource, Result outputTarget)
     */
    public DOMSource() { }

    /**
     * Create a new input source with a DOM node.  The operation
     * will be applied to the subtree rooted at this node.  In XSLT,
     * a "/" pattern still means the root of the tree (not the subtree),
     * and the evaluation of global variables and parameters is done
     * from the root node also.
     *
     * @param n The DOM node that will contain the Source tree.
     */
    public DOMSource(Node n) {
        setNode(n);
    }

    /**
     * Create a new input source with a DOM node, and with the
     * system ID also passed in as the base URI.
     *
     * @param node The DOM node that will contain the Source tree.
     * @param systemID Specifies the base URI associated with node.
     */
    public DOMSource(Node node, String systemID) {
        setNode(node);
        setSystemId(systemID);
    }

    /**
     * Set the node that will represents a Source DOM tree.
     *
     * @param node The node that is to be transformed.
     */
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * Get the node that represents a Source DOM tree.
     *
     * @return The node that is to be transformed.
     */
    public Node getNode() {
        return node;
    }

    /**
     * Set the base ID (URL or system ID) from where URLs
     * will be resolved.
     *
     * @param systemID Base URL for this DOM tree.
     */
    public void setSystemId(String systemID) {
        this.systemID = systemID;
    }

    /**
     * Get the base ID (URL or system ID) from where URLs
     * will be resolved.
     *
     * @return Base URL for this DOM tree.
     */
    public String getSystemId() {
        return this.systemID;
    }
}

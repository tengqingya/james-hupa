/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.hupa.shared.data;

import java.io.Serializable;
import java.util.ArrayList;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.List;

import org.apache.hupa.shared.rf.EntityBase;
=======
>>>>>>> first commit
=======
import java.util.List;

<<<<<<< HEAD
import javax.servlet.http.HttpSession;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
>>>>>>> As the FetchFolders RequestFactory, but can not run correctly.
=======
import org.apache.hupa.shared.rf.EntityBase;
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.

/**
 * IMAPFolder
 * 
 */
<<<<<<< HEAD
<<<<<<< HEAD
public class IMAPFolder extends EntityBase implements Serializable {
	
	private Long id;
	private Long version;
	

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

	/**
=======
public class IMAPFolder implements Serializable {
<<<<<<< HEAD

    /**
>>>>>>> first commit
=======
=======
public class IMAPFolder extends EntityBase implements Serializable {
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
	
	private Long id;
	private Long version;
	

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	

	/**
>>>>>>> As the FetchFolders RequestFactory, but can not run correctly.
     * 
     */
    private static final long serialVersionUID = 2084188092060266479L;

<<<<<<< HEAD
<<<<<<< HEAD
    private List<IMAPFolder> childs = new ArrayList<IMAPFolder>();
=======
    private ArrayList<IMAPFolder> childs = new ArrayList<IMAPFolder>();
>>>>>>> first commit
=======
    private List<IMAPFolder> childs = new ArrayList<IMAPFolder>();
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
    private String fullName;
    private String delimiter;
    private int msgCount;
    private int unseenMsgCount;
    private boolean subscribed = false;

    public IMAPFolder() {
    }

    public IMAPFolder(String fullName) {
        setFullName(fullName);
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }
    
    public boolean getSubscribed() {
        return subscribed;
    }
    
    
    /**
     * Get the name of the folder
     * 
     * @return name
     */
    public String getName() {
        if (delimiter != null) {
            String fParts[] = getFullName().split("\\" + delimiter);
            if (fParts != null && fParts.length > 0) {
                return fParts[fParts.length - 1];
            }
        }
        return fullName;
    }

    /**
     * Set the child folders 
     * 
     * @param childs
     */
<<<<<<< HEAD
<<<<<<< HEAD
    public void setChildIMAPFolders(List<IMAPFolder> childs) {
=======
    public void setChildIMAPFolders(ArrayList<IMAPFolder> childs) {
>>>>>>> first commit
=======
    public void setChildIMAPFolders(List<IMAPFolder> childs) {
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        this.childs = childs;
    }

    /**
     * Return the childs of this folder
     * 
     * @return childs
     */
<<<<<<< HEAD
<<<<<<< HEAD
    public List<IMAPFolder> getChildIMAPFolders() {
=======
    public ArrayList<IMAPFolder> getChildIMAPFolders() {
>>>>>>> first commit
=======
    public List<IMAPFolder> getChildIMAPFolders() {
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        return childs;
    }

    /**
     * Return the full name of the folder. This include the full path
     * @return Full name of the folder
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Set the full name of the folder
     * 
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Set the delimiter which is used to seperate folders
     * 
     * @param delimiter
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Return the delimiter
     * 
     * @return delimiter
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Return the total message count of the messages that exists within this folder
     * 
     * @return msgCount
     */
    public int getMessageCount() {
        return msgCount;
    }

    /**
     * Set total message count
     * 
     * @param msgCount
     */
    public void setMessageCount(int msgCount) {
        this.msgCount = msgCount;
    }

    /**
     * Set the count of all unseen messages within this folder
     * 
     * @param unseenMsgCount
     */
    public void setUnseenMessageCount(int unseenMsgCount) {
        this.unseenMsgCount = unseenMsgCount;
    }

    /**
     * Return the unseen message count
     * 
     * @return unseenMsgCount
     */
    public int getUnseeMessageCount() {
        return unseenMsgCount;
    }

    @Override
    public String toString() {
        return getFullName();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof IMAPFolder) {
            if (((IMAPFolder) o).getFullName().equals(getFullName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getFullName().hashCode();
    }
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> first commit
=======

>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
    
}

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

package org.apache.hupa.client.widgets;

<<<<<<< HEAD
<<<<<<< HEAD
import org.apache.hupa.shared.domain.ImapFolder;
import org.apache.hupa.widgets.event.EditEvent;
import org.apache.hupa.widgets.ui.EditableTreeItem;

public class IMAPTreeItem extends EditableTreeItem {
	protected String oldFullName;
	protected String oldName;

	public IMAPTreeItem(ImapFolder folder) {
		setUserObject(folder);
		setFolderText(folder);
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		if (isSelected()) {
			getWidget().addStyleName("hupa-IMAPFolder-selected");
		} else {
			getWidget().removeStyleName("hupa-IMAPFolder-selected");
		}
	}

	/**
	 * Decrease the unseen messagecount of this folder
	 */
	public void decreaseUnseenMessageCount() {
		descreaseUnseenMessageCount(1);
	}

	public void setUnseenMessageCount(int cound) {
		ImapFolder folder = (ImapFolder) getUserObject();
		int count = folder.getUnseenMessageCount();
		folder.setUnseenMessageCount(count);
		setFolderText(folder);

	}

	/**
	 * Decrease the unseen messagecount of this folder
	 */
	public void descreaseUnseenMessageCount(int decreaseCount) {
		ImapFolder folder = (ImapFolder) getUserObject();
		int count = folder.getUnseenMessageCount();
		if (count > 0) {
			count = count - decreaseCount;
			if (count < 0) {
				count = 0;
			}
			folder.setUnseenMessageCount(count);
			setFolderText(folder);
		}
	}
	/**
	 * Increase the unseen messagecount of this folder
	 */
	public void increaseUnseenMessageCount() {
		increaseUnseenMessageCount(1);
	}

	/**
	 * Increase the unseen messagecount of this folder
	 */
	public void increaseUnseenMessageCount(int increaseCount) {
		ImapFolder folder = (ImapFolder) getUserObject();
		int count = folder.getUnseenMessageCount();
		count = count + increaseCount;
		folder.setUnseenMessageCount(count);
		setFolderText(folder);
	}

	private void setFolderText(ImapFolder folder) {
		setText(getFolderName(folder));
		setUnseenMessageCountStyle(folder);
	}

	private void setUnseenMessageCountStyle(ImapFolder folder) {
		boolean containsUnseen = (folder.getUnseenMessageCount() > 0);
		for (ImapFolder fold : folder.getChildren()) {
			if (fold.getUnseenMessageCount() > 0) {
				containsUnseen = true;
				break;
			}
		}
		if (containsUnseen) {
			getWidget().addStyleName("hupa-IMAPFolder-unseen");
		} else {
			getWidget().removeStyleName("hupa-IMAPFolder-unseen");
		}
	}

	/**
	 * Return the folder name to display in the TreeItem for the given
	 * IMAPFolder
	 * 
	 * @param folder
	 * @return name
	 */
	private String getFolderName(ImapFolder folder) {
		if (folder.getUnseenMessageCount() > 0) {
			return folder.getName() + " (" + folder.getUnseenMessageCount() + ")";
		}
		return folder.getName();
	}

	@Override
	public void setUserObject(Object obj) {
		if ((obj instanceof ImapFolder) == false) {
			throw new IllegalArgumentException("UserObject needs to be an instance of IMAPFolder");
		}
		setFolderText((ImapFolder) obj);

		super.setUserObject(obj);
	}

	@Override
	public void startEdit() {
		ImapFolder folder = (ImapFolder) getUserObject();
		oldFullName = folder.getFullName();
		oldName = folder.getName();
		showEditBox(oldName);
		manager.fireEvent(new EditEvent(EditEvent.EventType.Start, oldFullName, null));
	}

	@Override
	public void cancelEdit() {
		ImapFolder folder = ((ImapFolder) getUserObject());
		folder.setFullName(oldFullName);
		showItem(getFolderName(folder));

		manager.fireEvent(new EditEvent(EditEvent.EventType.Cancel, oldFullName, null));

	}

	@Override
	public void stopEdit() {
		if (editBox.getText().length() < 1) {
			// Empty folder name is not allowed!
			cancelEdit();
		} else {
			String newFolderName = editBox.getText();
			String newFullFolderName = oldFullName.substring(0, oldFullName.length() - oldName.length())
					+ newFolderName;
			ImapFolder folder = ((ImapFolder) getUserObject());
			folder.setFullName(newFullFolderName);
			showItem(getFolderName(folder));

			manager.fireEvent(new EditEvent(EditEvent.EventType.Stop, oldFullName, newFullFolderName));
		}

	}
=======
import org.apache.hupa.shared.data.IMAPFolder;
import org.apache.hupa.shared.proxy.IMAPFolderProxy;
=======
import org.apache.hupa.shared.data.IMAPFolder;
<<<<<<< HEAD
>>>>>>> first commit
=======
import org.apache.hupa.shared.proxy.IMAPFolderProxy;
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
import org.apache.hupa.widgets.event.EditEvent;
import org.apache.hupa.widgets.ui.EditableTreeItem;

public class IMAPTreeItem extends EditableTreeItem {    
    protected String oldFullName;
    protected String oldName;

<<<<<<< HEAD
<<<<<<< HEAD
    public IMAPTreeItem(IMAPFolderProxy folder) {
=======
    public IMAPTreeItem(IMAPFolder folder) {
>>>>>>> first commit
=======
    public IMAPTreeItem(IMAPFolderProxy folder) {
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        setUserObject(folder);
        setFolderText(folder);    
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (isSelected()) {
            getWidget().addStyleName("hupa-IMAPFolder-selected");
        } else {
            getWidget().removeStyleName("hupa-IMAPFolder-selected");
        }
    }
    
    /**
     * Decrease the unseen messagecount of this folder
     */
    public void decreaseUnseenMessageCount() {
        descreaseUnseenMessageCount(1);
    }
    
    public void setUnseenMessageCount(int cound) {
<<<<<<< HEAD
<<<<<<< HEAD
    	IMAPFolderProxy folder = (IMAPFolderProxy) getUserObject();
=======
        IMAPFolder folder = (IMAPFolder) getUserObject();
>>>>>>> first commit
=======
    	IMAPFolderProxy folder = (IMAPFolderProxy) getUserObject();
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        int count = folder.getUnseeMessageCount();
        folder.setUnseenMessageCount(count);
        setFolderText(folder);
        
    }
    
    
    /**
     * Decrease the unseen messagecount of this folder
     */
    public void descreaseUnseenMessageCount(int decreaseCount) {
<<<<<<< HEAD
<<<<<<< HEAD
    	IMAPFolderProxy folder = (IMAPFolderProxy) getUserObject();
=======
        IMAPFolder folder = (IMAPFolder) getUserObject();
>>>>>>> first commit
=======
    	IMAPFolderProxy folder = (IMAPFolderProxy) getUserObject();
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        int count = folder.getUnseeMessageCount();
        if (count > 0) { 
            count = count - decreaseCount;
            if (count < 0) {
                count = 0;
            }
            folder.setUnseenMessageCount(count);
            setFolderText(folder);
        } 
    }
    /**
     * Increase the unseen messagecount of this folder
     */
    public void increaseUnseenMessageCount() {
        increaseUnseenMessageCount(1);
    }
    
    /**
     * Increase the unseen messagecount of this folder
     */
    public void increaseUnseenMessageCount( int increaseCount) {
<<<<<<< HEAD
<<<<<<< HEAD
    	IMAPFolderProxy folder = (IMAPFolderProxy) getUserObject();
=======
        IMAPFolder folder = (IMAPFolder) getUserObject();
>>>>>>> first commit
=======
    	IMAPFolderProxy folder = (IMAPFolderProxy) getUserObject();
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        int count = folder.getUnseeMessageCount(); 
        count = count+ increaseCount;
        folder.setUnseenMessageCount(count);
        setFolderText(folder);
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
    private void setFolderText(IMAPFolderProxy folder) {
=======
    private void setFolderText(IMAPFolder folder) {
>>>>>>> first commit
=======
    private void setFolderText(IMAPFolderProxy folder) {
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        setText(getFolderName(folder));
        setUnseenMessageCountStyle(folder);
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
    private void setUnseenMessageCountStyle(IMAPFolderProxy folder) {
        boolean containsUnseen = (folder.getUnseeMessageCount() > 0);
        for (IMAPFolderProxy fold : folder.getChildIMAPFolders()) {
=======
    private void setUnseenMessageCountStyle(IMAPFolder folder) {
        boolean containsUnseen = (folder.getUnseeMessageCount() > 0);
        for (IMAPFolder fold : folder.getChildIMAPFolders()) {
>>>>>>> first commit
=======
    private void setUnseenMessageCountStyle(IMAPFolderProxy folder) {
        boolean containsUnseen = (folder.getUnseeMessageCount() > 0);
        for (IMAPFolderProxy fold : folder.getChildIMAPFolders()) {
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
            if (fold.getUnseeMessageCount() > 0) {
                containsUnseen = true;
                break;
            }
        }
        if (containsUnseen) {
            getWidget().addStyleName("hupa-IMAPFolder-unseen");
        } else {
            getWidget().removeStyleName("hupa-IMAPFolder-unseen");
        }
    }
    
    /**
     * Return the folder name to display in the TreeItem for the given IMAPFolder
     * 
     * @param folder
     * @return name
     */
<<<<<<< HEAD
<<<<<<< HEAD
    private String getFolderName(IMAPFolderProxy folder) {
=======
    private String getFolderName(IMAPFolder folder) {
>>>>>>> first commit
=======
    private String getFolderName(IMAPFolderProxy folder) {
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        if (folder.getUnseeMessageCount() > 0) {
            return folder.getName() + " ("+folder.getUnseeMessageCount()+")";
        }
        return folder.getName();
    }
    
    @Override
    public void setUserObject(Object obj) {
<<<<<<< HEAD
<<<<<<< HEAD
        if ((obj instanceof IMAPFolderProxy) == false) {
            throw new IllegalArgumentException("UserObject needs to be an instance of IMAPFolder");
        }        
        setFolderText((IMAPFolderProxy)obj);
=======
        if ((obj instanceof IMAPFolder) == false) {
            throw new IllegalArgumentException("UserObject needs to be an instance of IMAPFolder");
        }        
        setFolderText((IMAPFolder)obj);
>>>>>>> first commit
=======
        if ((obj instanceof IMAPFolderProxy) == false) {
            throw new IllegalArgumentException("UserObject needs to be an instance of IMAPFolder");
        }        
        setFolderText((IMAPFolderProxy)obj);
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.

        super.setUserObject(obj);
    }

    @Override
    public void startEdit() {
<<<<<<< HEAD
<<<<<<< HEAD
    	IMAPFolderProxy folder = (IMAPFolderProxy) getUserObject();
=======
        IMAPFolder folder = (IMAPFolder) getUserObject();
>>>>>>> first commit
=======
    	IMAPFolderProxy folder = (IMAPFolderProxy) getUserObject();
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        oldFullName = folder.getFullName();
        oldName = folder.getName();
        showEditBox(oldName);
        manager.fireEvent(new EditEvent(EditEvent.EventType.Start,oldFullName,null));
    }
    
    @Override
    public void cancelEdit() {
<<<<<<< HEAD
<<<<<<< HEAD
    	IMAPFolderProxy folder = ((IMAPFolderProxy) getUserObject());
=======
        IMAPFolder folder = ((IMAPFolder) getUserObject());
>>>>>>> first commit
=======
    	IMAPFolderProxy folder = ((IMAPFolderProxy) getUserObject());
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
        folder.setFullName(oldFullName);
        showItem(getFolderName(folder));

        manager.fireEvent(new EditEvent(EditEvent.EventType.Cancel,oldFullName,null));

    }
    
    @Override
    public void stopEdit() {
        if (editBox.getText().length() < 1) {
            // Empty folder name is not allowed!
            cancelEdit();
        } else {
            String newFolderName = editBox.getText();
            String newFullFolderName = oldFullName.substring(0, oldFullName.length() - oldName.length())  + newFolderName; 
<<<<<<< HEAD
<<<<<<< HEAD
            IMAPFolderProxy folder = ((IMAPFolderProxy) getUserObject());
=======
            IMAPFolder folder = ((IMAPFolder) getUserObject());
>>>>>>> first commit
=======
            IMAPFolderProxy folder = ((IMAPFolderProxy) getUserObject());
>>>>>>> Aim to make the front end view work after the server side's IMAPFolder services RF being working, but there are issues on RF's find* method, I think.
            folder.setFullName(newFullFolderName);
            showItem(getFolderName(folder));

            manager.fireEvent(new EditEvent(EditEvent.EventType.Stop,oldFullName,newFullFolderName));
        }

    }
<<<<<<< HEAD
>>>>>>> first commit
=======
>>>>>>> first commit
}

package com.ehome.dts.wx.common.bean.result;

import com.ehome.dts.wx.common.bean.Backlog;
import com.ehome.dts.wx.common.bean.User;


/**
 * 消息
 * 
 * @author yangxi
 */
public class Message{
	/**
	 * 消息类型，系统通知
	 */
	public static final int MESSAGE_TYPE_SYSTEM = 1;
	/**
	 * 消息类型，待办事项通知
	 */
	public static final int MESSAGE_TYPE_SCHEDULE = 2;
	/**
	 * 消息类型，普通聊天消息
	 */
	public static final int MESSAGE_TYPE_P2P = 3;
	/**
	 * 消息类型，带处理动作的消息
	 */
	public static final int MESSAGE_TYPE_BACKLOG = 4;
	/**
	 * 消息类型，商家端欢迎语
	 */
	public static final int MESSAGE_TYPE_WELCOME = 5;

	private String title;
	private String content;
	private int type;// 消息类型
	private boolean unread;//是否未读
	private int messageGroupId;// 会话Id，通讯录中直接聊天不注入
	private String pic;// 图片
	private Shop shop;
	private User sendUser;
	private Backlog backlog;

	public Message() {
	}
	public Message(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public boolean isUnread() {
		return unread;
	}
	public void setUnread(boolean unread) {
		this.unread = unread;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Backlog getBacklog() {
		return backlog;
	}
	public void setBacklog(Backlog backlog) {
		this.backlog = backlog;
	}
	public int getMessageGroupId() {
		return messageGroupId;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public void setMessageGroupId(int messageGroupId) {
		this.messageGroupId = messageGroupId;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public User getSendUser() {
		return sendUser;
	}
	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}
}

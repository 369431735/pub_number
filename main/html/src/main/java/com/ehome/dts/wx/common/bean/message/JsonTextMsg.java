package com.ehome.dts.wx.common.bean.message;


/**
 * {
 *  "touser":"OPENID",
 *  "msgtype":"text",
 *  "text":
 *  {
 *       "content":"Hello World"
 *  }
 * }
 * @author <a href="xi.yang@i-jia.net">yangxi</a>
 */
public class JsonTextMsg {
//	public static void main(String[] args) {
//		System.out.println(JSON.toJSONString(new JsonTextMsg("12345678", "abjlsjdf")));
//	}
	private String touser;
	private String msgtype;
	private Text text;
	public JsonTextMsg(String touser,String content) {
		this.msgtype = "text";
		this.touser = touser;
		this.text = new Text(content);
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public Text getText() {
		return text;
	}
	public void setText(Text text) {
		this.text = text;
	}
}

class Text {
	public Text(String content) {
		this.content = content;
	}
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

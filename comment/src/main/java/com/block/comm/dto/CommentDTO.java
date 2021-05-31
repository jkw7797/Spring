package com.block.comm.dto;

import java.sql.Timestamp;

public class CommentDTO {
	private int commentNum;
	private String content;
	private String id;
	private Timestamp commentDate;
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
	@Override
	public String toString() {
		return "CommentDTO [commentNum=" + commentNum + ", content=" + content + ", id=" + id + ", commentDate="
				+ commentDate + "]";
	}
	
	

}

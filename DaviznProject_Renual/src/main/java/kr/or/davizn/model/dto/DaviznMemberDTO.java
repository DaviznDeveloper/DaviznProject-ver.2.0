package kr.or.davizn.model.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class DaviznMemberDTO {

	
	private String userid;
	private String password;
	private String nickname;
	private int phone;
	private int point;
	private String profile_img;
	private CommonsMultipartFile uploadImage;
	
	public CommonsMultipartFile getUploadImage() {
		return uploadImage;
	}
	public void setUploadImage(CommonsMultipartFile uploadImage) {
		this.uploadImage = uploadImage;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	
	
	
}
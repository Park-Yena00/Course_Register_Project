package Valueobject;

import java.util.Scanner;
//coderabbit review
public class VLecture {
	//코드, 강좌명, 교수명, 학점, 강좌시간
	private int code;
	private String title;
	private String lecturer; //교수
	private int credit; //학점
	private String time; //강좌시간
	
	public int getCode() {
		return code;}
	public void setCode(int code) {
		this.code = code;}
	
	public String getTitle() {
		return title;}
	public void setTitle(String title) {
		this.title = title;}
	
	public String getLecturer() {
		return lecturer;}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;}
	
	public int getCredit() {
		return credit;}
	public void setCredit(int credit) {
		this.credit = credit;}
	
	public String getTime() {
		return time;}
	public void setTime(String time) {
		this.time = time;}

	public void load(Scanner parentFile) {
		this.setCode(parentFile.nextInt());
		this.setTitle(parentFile.next());
		this.setLecturer(parentFile.next());
		this.setCredit(parentFile.nextInt());
		this.setTime(parentFile.next());
	}
	public void show() {
		System.out.println(
				this.getCode()
				+" "+this.getTitle()
				+" "+this.getLecturer()
				+" "+this.getCredit()
				+" "+this.getTime()
				);
		
	}
}

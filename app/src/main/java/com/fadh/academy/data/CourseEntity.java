package com.fadh.academy.data;

public class CourseEntity {
    private String courseid;
    private String title;
    private String description;
    private String deadline;
    private boolean bookmark = false;
    private String imagePath;

    public CourseEntity(String courseid, String title, String deadline, String description , Boolean bookmark , String imagePath){
        this.courseid = courseid;
        this.deadline = deadline;
        this.description = description;
        this.imagePath = imagePath;
        this.deadline = deadline;
        if (bookmark != null){
            this.bookmark = bookmark;
        }
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isBookmark() {
        return bookmark;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

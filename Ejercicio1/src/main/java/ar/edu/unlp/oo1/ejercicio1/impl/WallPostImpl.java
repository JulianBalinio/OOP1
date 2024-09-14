package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

public class WallPostImpl implements WallPost {

	private String text = "Undefined post";
	private int likes = 0;
	private boolean featured = false;
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getLikes() {
		return this.likes;
	}
	
	public void like() {
		this.likes++;
	}
	
	public void dislike() {
		if(this.likes > 0) {
			this.likes--;
		}
	}
	
	public void toggleFeatured() {
		this.featured = !this.featured;
	}
	
	public boolean isFeatured() {
		return this.featured;
	}
	
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

}

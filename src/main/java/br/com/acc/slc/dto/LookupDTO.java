package br.com.acc.slc.dto;

import java.util.ArrayList;
import java.util.List;

public class LookupDTO {
    private List<? extends Object> items;
    private boolean hasNext;

    public List<? extends Object> getItems() {
	if (items == null) {
	    items = new ArrayList<>();
	}
	return items;
    }

    public void setItems(List<? extends Object> items) {
	this.items = items;
    }

    public boolean isHasNext() {
	return hasNext;
    }

    public void setHasNext(boolean hasNext) {
	this.hasNext = hasNext;
    }

}

package com.model;

import java.util.Date;
import java.util.UUID;

public class Log {
	 private UUID id;
	    private String title;
	    private String content;
	    private Date createTimestamp;

	    public Log() {
	    }

		public UUID getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public String getContent() {
			return content;
		}

		public Date getCreateTimestamp() {
			return createTimestamp;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public void setCreateTimestamp(Date createTimestamp) {
			this.createTimestamp = createTimestamp;
		}
}

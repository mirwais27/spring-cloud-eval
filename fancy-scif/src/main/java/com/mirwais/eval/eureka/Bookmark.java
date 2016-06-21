package com.mirwais.eval.eureka;

public class Bookmark {

    private String userId;

    private Long id;

    private String href;

    private String description;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    private String host;

    private String port;

    Bookmark() {
    }

    public Bookmark(String userId, String href,
                    String description, String label) {
        this.userId = userId;
        this.href = href;
        this.description = description;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public String getHref() {
        return href;
    }

    public String getDescription() {
        return description;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    private String label;

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", href='" + href + '\'' +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", userId='" + userId + '\'' +
                ", server.port='" + port + '\'' +
                '}';
    }
}
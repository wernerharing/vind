package com.rbmhtechnology.vind.report.model.application;

/**
 * @author Thomas Kurz (tkurz@apache.org)
 * @since 01.08.16.
 */
public class SimpleApplication implements Application {

    private String id;

    public SimpleApplication(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

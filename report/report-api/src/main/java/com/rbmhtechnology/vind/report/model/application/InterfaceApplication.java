package com.rbmhtechnology.vind.report.model.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbmhtechnology.vind.report.model.Interface.Interface;

/**
 * @author Thomas Kurz (tkurz@apache.org)
 * @since 01.08.16.
 */
public class InterfaceApplication implements Application {

    private String name;
    private String version;
    @JsonProperty("interface")
    private Interface iface;

    public InterfaceApplication(String name, String version, Interface iface) {
        this.name = name;
        this.version = version;
        this.iface = iface;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public Interface getIface() {
        return iface;
    }
}

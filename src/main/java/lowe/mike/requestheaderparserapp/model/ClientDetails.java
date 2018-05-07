package lowe.mike.requestheaderparserapp.model;

import java.util.Objects;

public class ClientDetails {

    private final String ipaddress;
    private final String language;
    private final String software;

    public ClientDetails(String ipaddress, String language, String software) {
        this.ipaddress = ipaddress;
        this.language = language;
        this.software = software;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public String getLanguage() {
        return language;
    }

    public String getSoftware() {
        return software;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDetails that = (ClientDetails) o;
        return Objects.equals(ipaddress, that.ipaddress) &&
                Objects.equals(language, that.language) &&
                Objects.equals(software, that.software);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipaddress, language, software);
    }

    @Override
    public String toString() {
        return "ClientDetails{" +
                "ipaddress='" + ipaddress + '\'' +
                ", language='" + language + '\'' +
                ", software='" + software + '\'' +
                '}';
    }

}

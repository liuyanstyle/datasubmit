package bean;

public class Webvisit {
    public void setId(int id) {
        this.id = id;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public void setPvVisit(long pvVisit) {
        this.pvVisit = pvVisit;
    }

    public void setUvVisit(long uvVisit) {
        this.uvVisit = uvVisit;
    }

    public int getId() {

        return id;
    }

    public String getYear() {
        return year;
    }

    public String getWebname() {
        return webname;
    }

    public long getPvVisit() {
        return pvVisit;
    }

    public long getUvVisit() {
        return uvVisit;
    }

    public int id;
    public String year;
    public String webname;
    public long pvVisit;
    public long uvVisit;

}

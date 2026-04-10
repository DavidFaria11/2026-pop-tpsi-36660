public class Artigo implements IArtigo {
    private int codigoArt;
    private String tituloArt;
    private String descrArt;

    public Artigo(int codigoArt, String tituloArt, String descrArt) {
        this.codigoArt = codigoArt;
        this.tituloArt = tituloArt;
        this.descrArt = descrArt;
    }

    @Override
    public int getCodigoArt() {
        return codigoArt;
    }

    @Override
    public String getTituloArt() {
        return tituloArt;
    }

    @Override
    public String getDescrArt() {
        return descrArt;
    }

    @Override
    public void setCodigoArt(int cod) {
        this.codigoArt = cod;
    }

    @Override
    public void setTituloArt(String titulo) {
        this.tituloArt = titulo;
    }

    @Override
    public void setDescrArt(String descr) {
        this.descrArt = descr;
    }

    @Override
    public String toString() {
        return "Artigo [" + codigoArt + "] " + tituloArt + " - " + descrArt;
    }
}
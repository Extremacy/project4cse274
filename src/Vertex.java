public class Vertex {
    public String symbol;
    public String address;

    public Vertex(String symbol, String address) {
        this.symbol = symbol;
        this.address = address;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += getSymbol();
        ret +=  " , " + getAddress();
        return ret;
    }




}
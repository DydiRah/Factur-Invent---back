package facture.Modele;

import java.util.Date;
import java.util.List;

public class StockInfo {
    Date date1;
    Date date2;
    List<EtatStock> etatStocks;
    double sommeMontant;

    public StockInfo(Date date1, Date date2, List<EtatStock> etatStocks) {
        setDate1(date1);
        setDate2(date2);
        setEtatStocks(etatStocks);
        setSommeMontant(etatStocks);
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public List<EtatStock> getEtatStocks() {
        return etatStocks;
    }

    public void setEtatStocks(List<EtatStock> etatStocks) {
        this.etatStocks = etatStocks;
    }

    public double getSommeMontant() {
        return sommeMontant;
    }

    public void setSommeMontant(double sommeMontant) {
        this.sommeMontant = sommeMontant;
    }

    public void setSommeMontant(List<EtatStock> etatStocks){
        double total = 0;
        for (EtatStock etatStock:etatStocks) {
            total += etatStock.getMontant();
        }
        this.sommeMontant = total;
    }
}

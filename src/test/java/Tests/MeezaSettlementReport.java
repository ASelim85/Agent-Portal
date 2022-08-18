package Tests;

import APIS.CashOut;
import APIS.Deposit;
import APIS.P2P;
import Utils.ExcelFileManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import APIS.P2P.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;

public class MeezaSettlementReport extends TestBase {

    P2P p2p = new P2P();
    CashOut cashout = new CashOut();

    Deposit deposit = new Deposit();

    @Test
    public void Receive_P2P_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //VOLUMES
        //Transactions
        String transactionPrevTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionPrevTrx = transactionPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionPrevTrx = new BigDecimal(finaltransactionPrevTrx);
        System.out.println("Transaction: " + finaNumberTransactionPrevTrx);

        //Interchange Debit
        String InterchangeDebitPrevTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitPrevTrx = InterchangeDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitPrevTrx = new BigDecimal(finalInterchangeDebitPrevTrx);
        System.out.println("Interchange Debit: " + finaNumberInterchangeDebitPrevTrx);

        //Total Debit
        String TotalDebitPrevTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitPrevTrx = TotalDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitPrevTrx = new BigDecimal(finalTotalDebitPrevTrx);
        System.out.println("Total Debit: " + finaNumberTotalDebitPrevTrx);

        //Interchange Credit
        String InterchangeCreditPrevTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditPrevTrx = InterchangeCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditPrevTrx = new BigDecimal(finalInterchangeCreditPrevTrx);
        System.out.println("Interchange Credit: " + finaNumberInterchangeCreditPrevTrx);

        //Total Credit
        String TotalCreditPrevTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditPrevTrx = TotalCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditPrevTrx = new BigDecimal(finalTotalCreditPrevTrx);
        System.out.println("Total Credit: " + finaNumberTotalCreditPrevTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String transactionPrevVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionPrevVal = transactionPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionPrevVal = new BigDecimal(finaltransactionPrevVal);
        System.out.println("Transaction: " + finaNumbertransactionPrevVal);

        //InterChange Debit Value
        String InterchangeDebitPrevVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitPrevVal = InterchangeDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitPrevVal = new BigDecimal(finalInterchangeDebitPrevVal);
        System.out.println("Interchange Debit Value: " + finaNumberInterchangeDebitPrevVal);

        //Total Debit
        String totalDebitPrevVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitPrevVal = totalDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitPrevVal = new BigDecimal(finalTotalDebitPrevVal);
        System.out.println("Total Debit Value: " + finaNumberTotalDebitPrevVal);

        //Interchange Credit
        String InterchangeCreditPrevVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditPrevVal = InterchangeCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditPrevVal = new BigDecimal(finalInterchangeCreditPrevVal);
        System.out.println("Interchange Credit Value: " + finaNumberInterchangeCreditPrevVal);

        //Total Credit
        String TotalCreditPrevVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditPrevVal = TotalCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditPrevVal = new BigDecimal(finalTotalCreditPrevVal);
        BigDecimal finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevVal.add(new BigDecimal(31));
        finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevValRoundup.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println("Total Credit Value: " + finaNumberTotalCreditPrevVal);

        //Processing Fees
        String ProcessingFees = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFees = ProcessingFees.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFees = new BigDecimal(finalProcessingFees);
        BigDecimal finaNumberProcessingFeesRoundUp = finaNumberProcessingFees.add(new BigDecimal(0.15));
        finaNumberProcessingFeesRoundUp = finaNumberProcessingFeesRoundUp.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println("Processing Fees Value: " + finaNumberProcessingFees);

        //Net Position
        String NetPosition = meezaReportPage.getNetPositionPrevValue();
        String finalNetPosition = NetPosition.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPosition = new BigDecimal(finalNetPosition);
        System.out.println("Net Position Value: " + finaNumberNetPosition);

        p2p.Receieve_P2P();
        p2p.Receieve_P2P_OffUs_Advice();
        refresh();

        //VOLUMES After
        //Transactions
        String transactionAfterTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionAfterTrx = transactionAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionAfterTrx = new BigDecimal(finaltransactionAfterTrx);

        //Interchange Debit
        String InterchangeDebitAfterTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitAfterTrx = InterchangeDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitAfterTrx = new BigDecimal(finalInterchangeDebitAfterTrx);

        //Total Debit
        String TotalDebitAfterTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitAfterTrx = TotalDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitAfterTrx = new BigDecimal(finalTotalDebitAfterTrx);

        //Interchange Credit
        String InterchangeCreditAfterTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditAfterTrx = InterchangeCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditAfterTrx = new BigDecimal(finalInterchangeCreditAfterTrx);

        //Total Credit
        String TotalCreditAfterTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditAfterTrx = TotalCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditAfterTrx = new BigDecimal(finalTotalCreditAfterTrx);


        Assert.assertEquals(finaNumberTransactionAfterTrx,finaNumberTransactionPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterTrx,finaNumberInterchangeDebitPrevTrx.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalDebitAfterTrx,finaNumberTotalDebitPrevTrx.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterTrx,finaNumberInterchangeCreditPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalCreditAfterTrx,finaNumberTotalCreditPrevTrx.add(new BigDecimal(1)));


        //Get Values
        meezaReportPage.clickValues();

        //Values After
        //Transactions
        String transactionAfterVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionAfterVal = transactionAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionAfterVal = new BigDecimal(finaltransactionAfterVal);

        //InterChange Debit Value
        String InterchangeDebitAfterVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitAfterVal = InterchangeDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitAfterVal = new BigDecimal(finalInterchangeDebitAfterVal);

        //Total Debit
        String totalDebitAfterVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitAfterVal = totalDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitAfterVal = new BigDecimal(finalTotalDebitAfterVal);

        //Interchange Credit
        String InterchangeCreditAfterVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditAfterVal = InterchangeCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditAfterVal = new BigDecimal(finalInterchangeCreditAfterVal);

        //Total Credit
        String TotalCreditAfterVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditAfterVal = TotalCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditAfterVal = new BigDecimal(finalTotalCreditAfterVal);

        //Processing Fees
        String ProcessingFeesAfter = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFeesAfter = ProcessingFeesAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFeesAfter = new BigDecimal(finalProcessingFeesAfter);

        //Net Position
        String NetPositionAfter = meezaReportPage.getNetPositionPrevValue();
        String finalNetPositionAfter = NetPositionAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPositionAfter = new BigDecimal(finalNetPositionAfter);


        Assert.assertEquals(finaNumbertransactionAfterVal,finaNumbertransactionPrevVal.add(new BigDecimal(30)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterVal,finaNumberInterchangeDebitPrevVal.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalDebitAfterVal,finaNumberTotalDebitPrevVal.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterVal,finaNumberInterchangeCreditPrevVal.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalCreditAfterVal,finaNumberTotalCreditPrevValRoundup);
        Assert.assertEquals(finaNumberProcessingFeesAfter,finaNumberProcessingFeesRoundUp);
        Assert.assertEquals(finaNumberNetPositionAfter,finaNumberNetPosition.add(new BigDecimal(31)));

    }

    @Test
    public void Send_P2P_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //VOLUMES
        //Transactions
        String transactionPrevTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionPrevTrx = transactionPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionPrevTrx = new BigDecimal(finaltransactionPrevTrx);
        System.out.println("Transaction: " + finaNumberTransactionPrevTrx);

        //Interchange Debit
        String InterchangeDebitPrevTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitPrevTrx = InterchangeDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitPrevTrx = new BigDecimal(finalInterchangeDebitPrevTrx);
        System.out.println("Interchange Debit: " + finaNumberInterchangeDebitPrevTrx);

        //Total Debit
        String TotalDebitPrevTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitPrevTrx = TotalDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitPrevTrx = new BigDecimal(finalTotalDebitPrevTrx);
        System.out.println("Total Debit: " + finaNumberTotalDebitPrevTrx);

        //Interchange Credit
        String InterchangeCreditPrevTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditPrevTrx = InterchangeCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditPrevTrx = new BigDecimal(finalInterchangeCreditPrevTrx);
        System.out.println("Interchange Credit: " + finaNumberInterchangeCreditPrevTrx);

        //Total Credit
        String TotalCreditPrevTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditPrevTrx = TotalCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditPrevTrx = new BigDecimal(finalTotalCreditPrevTrx);
        System.out.println("Total Credit: " + finaNumberTotalCreditPrevTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String transactionPrevVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionPrevVal = transactionPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionPrevVal = new BigDecimal(finaltransactionPrevVal);
        System.out.println("Transaction: " + finaNumbertransactionPrevVal);

        //InterChange Debit Value
        String InterchangeDebitPrevVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitPrevVal = InterchangeDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitPrevVal = new BigDecimal(finalInterchangeDebitPrevVal);
        System.out.println("Interchange Debit Value: " + finaNumberInterchangeDebitPrevVal);

        //Total Debit
        String totalDebitPrevVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitPrevVal = totalDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitPrevVal = new BigDecimal(finalTotalDebitPrevVal);
        System.out.println("Total Debit Value: " + finaNumberTotalDebitPrevVal);

        //Interchange Credit
        String InterchangeCreditPrevVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditPrevVal = InterchangeCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditPrevVal = new BigDecimal(finalInterchangeCreditPrevVal);
        System.out.println("Interchange Credit Value: " + finaNumberInterchangeCreditPrevVal);

        //Total Credit
        String TotalCreditPrevVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditPrevVal = TotalCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditPrevVal = new BigDecimal(finalTotalCreditPrevVal);
        BigDecimal finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevVal.add(new BigDecimal(0));
        finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevValRoundup.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println("Total Credit Value: " + finaNumberTotalCreditPrevVal);

        //Processing Fees
        String ProcessingFees = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFees = ProcessingFees.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFees = new BigDecimal(finalProcessingFees);
        BigDecimal finaNumberProcessingFeesRoundUp = finaNumberProcessingFees.add(new BigDecimal(1));
        finaNumberProcessingFeesRoundUp = finaNumberProcessingFeesRoundUp.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println("Processing Fees Value: " + finaNumberProcessingFees);

        //Net Position
        String NetPosition = meezaReportPage.getNetPositionPrevValue();
        String finalNetPosition = NetPosition.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPosition = new BigDecimal(finalNetPosition);
        System.out.println("Net Position Value: " + finaNumberNetPosition);

        p2p.Send_P2P();
        p2p.Send_P2P_OffUs_Advice();
        refresh();

        //VOLUMES After
        //Transactions
        String transactionAfterTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionAfterTrx = transactionAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionAfterTrx = new BigDecimal(finaltransactionAfterTrx);

        //Interchange Debit
        String InterchangeDebitAfterTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitAfterTrx = InterchangeDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitAfterTrx = new BigDecimal(finalInterchangeDebitAfterTrx);

        //Total Debit
        String TotalDebitAfterTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitAfterTrx = TotalDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitAfterTrx = new BigDecimal(finalTotalDebitAfterTrx);

        //Interchange Credit
        String InterchangeCreditAfterTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditAfterTrx = InterchangeCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditAfterTrx = new BigDecimal(finalInterchangeCreditAfterTrx);

        //Total Credit
        String TotalCreditAfterTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditAfterTrx = TotalCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditAfterTrx = new BigDecimal(finalTotalCreditAfterTrx);


        Assert.assertEquals(finaNumberTransactionAfterTrx,finaNumberTransactionPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterTrx,finaNumberInterchangeDebitPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalDebitAfterTrx,finaNumberTotalDebitPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterTrx,finaNumberInterchangeCreditPrevTrx.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalCreditAfterTrx,finaNumberTotalCreditPrevTrx.add(new BigDecimal(0)));


        //Get Values
        meezaReportPage.clickValues();

        //Values After
        //Transactions
        String transactionAfterVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionAfterVal = transactionAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionAfterVal = new BigDecimal(finaltransactionAfterVal);

        //InterChange Debit Value
        String InterchangeDebitAfterVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitAfterVal = InterchangeDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitAfterVal = new BigDecimal(finalInterchangeDebitAfterVal);

        //Total Debit
        String totalDebitAfterVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitAfterVal = totalDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitAfterVal = new BigDecimal(finalTotalDebitAfterVal);

        //Interchange Credit
        String InterchangeCreditAfterVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditAfterVal = InterchangeCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditAfterVal = new BigDecimal(finalInterchangeCreditAfterVal);

        //Total Credit
        String TotalCreditAfterVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditAfterVal = TotalCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditAfterVal = new BigDecimal(finalTotalCreditAfterVal);

        //Processing Fees
        String ProcessingFeesAfter = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFeesAfter = ProcessingFeesAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFeesAfter = new BigDecimal(finalProcessingFeesAfter);

        //Net Position
        String NetPositionAfter = meezaReportPage.getNetPositionPrevValue();
        String finalNetPositionAfter = NetPositionAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPositionAfter = new BigDecimal(finalNetPositionAfter);


        Assert.assertEquals(finaNumbertransactionAfterVal,finaNumbertransactionPrevVal.add(new BigDecimal(20)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterVal,finaNumberInterchangeDebitPrevVal.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalDebitAfterVal,finaNumberTotalDebitPrevVal.add(new BigDecimal(21)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterVal,finaNumberInterchangeCreditPrevVal.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalCreditAfterVal,finaNumberTotalCreditPrevValRoundup);
        Assert.assertEquals(finaNumberProcessingFeesAfter,finaNumberProcessingFeesRoundUp);
        Assert.assertEquals(finaNumberNetPositionAfter,finaNumberNetPosition.subtract(new BigDecimal(21)));
    }

    @Test
    public void ATM_Cashout_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //VOLUMES
        //Transactions
        String transactionPrevTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionPrevTrx = transactionPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionPrevTrx = new BigDecimal(finaltransactionPrevTrx);
        System.out.println("Transaction: " + finaNumberTransactionPrevTrx);

        //Interchange Debit
        String InterchangeDebitPrevTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitPrevTrx = InterchangeDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitPrevTrx = new BigDecimal(finalInterchangeDebitPrevTrx);
        System.out.println("Interchange Debit: " + finaNumberInterchangeDebitPrevTrx);

        //Total Debit
        String TotalDebitPrevTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitPrevTrx = TotalDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitPrevTrx = new BigDecimal(finalTotalDebitPrevTrx);
        System.out.println("Total Debit: " + finaNumberTotalDebitPrevTrx);

        //Interchange Credit
        String InterchangeCreditPrevTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditPrevTrx = InterchangeCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditPrevTrx = new BigDecimal(finalInterchangeCreditPrevTrx);
        System.out.println("Interchange Credit: " + finaNumberInterchangeCreditPrevTrx);

        //Total Credit
        String TotalCreditPrevTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditPrevTrx = TotalCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditPrevTrx = new BigDecimal(finalTotalCreditPrevTrx);
        System.out.println("Total Credit: " + finaNumberTotalCreditPrevTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String transactionPrevVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionPrevVal = transactionPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionPrevVal = new BigDecimal(finaltransactionPrevVal);
        System.out.println("Transaction: " + finaNumbertransactionPrevVal);

        //InterChange Debit Value
        String InterchangeDebitPrevVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitPrevVal = InterchangeDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitPrevVal = new BigDecimal(finalInterchangeDebitPrevVal);
        System.out.println("Interchange Debit Value: " + finaNumberInterchangeDebitPrevVal);

        //Total Debit
        String totalDebitPrevVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitPrevVal = totalDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitPrevVal = new BigDecimal(finalTotalDebitPrevVal);
        System.out.println("Total Debit Value: " + finaNumberTotalDebitPrevVal);

        //Interchange Credit
        String InterchangeCreditPrevVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditPrevVal = InterchangeCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditPrevVal = new BigDecimal(finalInterchangeCreditPrevVal);
        System.out.println("Interchange Credit Value: " + finaNumberInterchangeCreditPrevVal);

        //Total Credit
        String TotalCreditPrevVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditPrevVal = TotalCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditPrevVal = new BigDecimal(finalTotalCreditPrevVal);
        BigDecimal finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevVal.add(new BigDecimal(0));
        finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevValRoundup.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println("Total Credit Value: " + finaNumberTotalCreditPrevVal);

        //Processing Fees
        String ProcessingFees = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFees = ProcessingFees.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFees = new BigDecimal(finalProcessingFees);
        BigDecimal finaNumberProcessingFeesRoundUp = finaNumberProcessingFees.add(new BigDecimal(5));
        finaNumberProcessingFeesRoundUp = finaNumberProcessingFeesRoundUp.setScale(1,BigDecimal.ROUND_HALF_UP);
        System.out.println("Processing Fees Value: " + finaNumberProcessingFees);

        //Net Position
        String NetPosition = meezaReportPage.getNetPositionPrevValue();
        String finalNetPosition = NetPosition.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPosition = new BigDecimal(finalNetPosition);
        System.out.println("Net Position Value: " + finaNumberNetPosition);

        cashout.ATM_CashOut();
        cashout.ATM_CashOut_Advice();
        refresh();

        //VOLUMES After
        //Transactions
        String transactionAfterTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionAfterTrx = transactionAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionAfterTrx = new BigDecimal(finaltransactionAfterTrx);

        //Interchange Debit
        String InterchangeDebitAfterTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitAfterTrx = InterchangeDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitAfterTrx = new BigDecimal(finalInterchangeDebitAfterTrx);

        //Total Debit
        String TotalDebitAfterTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitAfterTrx = TotalDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitAfterTrx = new BigDecimal(finalTotalDebitAfterTrx);

        //Interchange Credit
        String InterchangeCreditAfterTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditAfterTrx = InterchangeCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditAfterTrx = new BigDecimal(finalInterchangeCreditAfterTrx);

        //Total Credit
        String TotalCreditAfterTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditAfterTrx = TotalCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditAfterTrx = new BigDecimal(finalTotalCreditAfterTrx);


        Assert.assertEquals(finaNumberTransactionAfterTrx,finaNumberTransactionPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterTrx,finaNumberInterchangeDebitPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalDebitAfterTrx,finaNumberTotalDebitPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterTrx,finaNumberInterchangeCreditPrevTrx.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalCreditAfterTrx,finaNumberTotalCreditPrevTrx.add(new BigDecimal(0)));


        //Get Values
        meezaReportPage.clickValues();

        //Values After
        //Transactions
        String transactionAfterVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionAfterVal = transactionAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionAfterVal = new BigDecimal(finaltransactionAfterVal);

        //InterChange Debit Value
        String InterchangeDebitAfterVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitAfterVal = InterchangeDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitAfterVal = new BigDecimal(finalInterchangeDebitAfterVal);

        //Total Debit
        String totalDebitAfterVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitAfterVal = totalDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitAfterVal = new BigDecimal(finalTotalDebitAfterVal);

        //Interchange Credit
        String InterchangeCreditAfterVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditAfterVal = InterchangeCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditAfterVal = new BigDecimal(finalInterchangeCreditAfterVal);

        //Total Credit
        String TotalCreditAfterVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditAfterVal = TotalCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditAfterVal = new BigDecimal(finalTotalCreditAfterVal);

        //Processing Fees
        String ProcessingFeesAfter = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFeesAfter = ProcessingFeesAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFeesAfter = new BigDecimal(finalProcessingFeesAfter);

        //Net Position
        String NetPositionAfter = meezaReportPage.getNetPositionPrevValue();
        String finalNetPositionAfter = NetPositionAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPositionAfter = new BigDecimal(finalNetPositionAfter);


        Assert.assertEquals(finaNumbertransactionAfterVal,finaNumbertransactionPrevVal.add(new BigDecimal(10)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterVal,finaNumberInterchangeDebitPrevVal.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalDebitAfterVal,finaNumberTotalDebitPrevVal.add(new BigDecimal(11)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterVal,finaNumberInterchangeCreditPrevVal.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalCreditAfterVal,finaNumberTotalCreditPrevValRoundup);
        Assert.assertEquals(finaNumberProcessingFeesAfter,finaNumberProcessingFeesRoundUp);
        Assert.assertEquals(finaNumberNetPositionAfter,finaNumberNetPosition.subtract(new BigDecimal(11)));
    }

    @Test
    public void ATM_Cashout_OffUs_Reversal() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //VOLUMES
        //Transactions
        String transactionPrevTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionPrevTrx = transactionPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionPrevTrx = new BigDecimal(finaltransactionPrevTrx);
        System.out.println("Transaction: " + finaNumberTransactionPrevTrx);

        //Interchange Debit
        String InterchangeDebitPrevTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitPrevTrx = InterchangeDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitPrevTrx = new BigDecimal(finalInterchangeDebitPrevTrx);
        System.out.println("Interchange Debit: " + finaNumberInterchangeDebitPrevTrx);

        //Total Debit
        String TotalDebitPrevTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitPrevTrx = TotalDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitPrevTrx = new BigDecimal(finalTotalDebitPrevTrx);
        System.out.println("Total Debit: " + finaNumberTotalDebitPrevTrx);

        //Interchange Credit
        String InterchangeCreditPrevTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditPrevTrx = InterchangeCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditPrevTrx = new BigDecimal(finalInterchangeCreditPrevTrx);
        System.out.println("Interchange Credit: " + finaNumberInterchangeCreditPrevTrx);

        //Total Credit
        String TotalCreditPrevTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditPrevTrx = TotalCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditPrevTrx = new BigDecimal(finalTotalCreditPrevTrx);
        System.out.println("Total Credit: " + finaNumberTotalCreditPrevTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String transactionPrevVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionPrevVal = transactionPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionPrevVal = new BigDecimal(finaltransactionPrevVal);
        System.out.println("Transaction: " + finaNumbertransactionPrevVal);

        //InterChange Debit Value
        String InterchangeDebitPrevVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitPrevVal = InterchangeDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitPrevVal = new BigDecimal(finalInterchangeDebitPrevVal);
        System.out.println("Interchange Debit Value: " + finaNumberInterchangeDebitPrevVal);

        //Total Debit
        String totalDebitPrevVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitPrevVal = totalDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitPrevVal = new BigDecimal(finalTotalDebitPrevVal);
        System.out.println("Total Debit Value: " + finaNumberTotalDebitPrevVal);

        //Interchange Credit
        String InterchangeCreditPrevVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditPrevVal = InterchangeCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditPrevVal = new BigDecimal(finalInterchangeCreditPrevVal);
        System.out.println("Interchange Credit Value: " + finaNumberInterchangeCreditPrevVal);

        //Total Credit
        String TotalCreditPrevVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditPrevVal = TotalCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditPrevVal = new BigDecimal(finalTotalCreditPrevVal);
        BigDecimal finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevVal.add(new BigDecimal(0));
        finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevValRoundup.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println("Total Credit Value: " + finaNumberTotalCreditPrevVal);

        //Processing Fees
        String ProcessingFees = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFees = ProcessingFees.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFees = new BigDecimal(finalProcessingFees);
        BigDecimal finaNumberProcessingFeesRoundUp = finaNumberProcessingFees.add(new BigDecimal(5));
        finaNumberProcessingFeesRoundUp = finaNumberProcessingFeesRoundUp.setScale(1,BigDecimal.ROUND_HALF_UP);
        System.out.println("Processing Fees Value: " + finaNumberProcessingFees);

        //Net Position
        String NetPosition = meezaReportPage.getNetPositionPrevValue();
        String finalNetPosition = NetPosition.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPosition = new BigDecimal(finalNetPosition);
        System.out.println("Net Position Value: " + finaNumberNetPosition);

        cashout.ATM_CashOut();
        cashout.ATM_CashOut_Advice();
        cashout.ATM_CashOut_Reversal();
        refresh();

        //VOLUMES After
        //Transactions
        String transactionAfterTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionAfterTrx = transactionAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionAfterTrx = new BigDecimal(finaltransactionAfterTrx);

        //Interchange Debit
        String InterchangeDebitAfterTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitAfterTrx = InterchangeDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitAfterTrx = new BigDecimal(finalInterchangeDebitAfterTrx);

        //Total Debit
        String TotalDebitAfterTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitAfterTrx = TotalDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitAfterTrx = new BigDecimal(finalTotalDebitAfterTrx);

        //Interchange Credit
        String InterchangeCreditAfterTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditAfterTrx = InterchangeCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditAfterTrx = new BigDecimal(finalInterchangeCreditAfterTrx);

        //Total Credit
        String TotalCreditAfterTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditAfterTrx = TotalCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditAfterTrx = new BigDecimal(finalTotalCreditAfterTrx);


        Assert.assertEquals(finaNumberTransactionAfterTrx,finaNumberTransactionPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterTrx,finaNumberInterchangeDebitPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalDebitAfterTrx,finaNumberTotalDebitPrevTrx.add(new BigDecimal(2)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterTrx,finaNumberInterchangeCreditPrevTrx.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalCreditAfterTrx,finaNumberTotalCreditPrevTrx.add(new BigDecimal(0)));


        //Get Values
        meezaReportPage.clickValues();

        //Values After
        //Transactions
        String transactionAfterVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionAfterVal = transactionAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionAfterVal = new BigDecimal(finaltransactionAfterVal);

        //InterChange Debit Value
        String InterchangeDebitAfterVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitAfterVal = InterchangeDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitAfterVal = new BigDecimal(finalInterchangeDebitAfterVal);

        //Total Debit
        String totalDebitAfterVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitAfterVal = totalDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitAfterVal = new BigDecimal(finalTotalDebitAfterVal);

        //Interchange Credit
        String InterchangeCreditAfterVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditAfterVal = InterchangeCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditAfterVal = new BigDecimal(finalInterchangeCreditAfterVal);

        //Total Credit
        String TotalCreditAfterVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditAfterVal = TotalCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditAfterVal = new BigDecimal(finalTotalCreditAfterVal);

        //Processing Fees
        String ProcessingFeesAfter = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFeesAfter = ProcessingFeesAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFeesAfter = new BigDecimal(finalProcessingFeesAfter);

        //Net Position
        String NetPositionAfter = meezaReportPage.getNetPositionPrevValue();
        String finalNetPositionAfter = NetPositionAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPositionAfter = new BigDecimal(finalNetPositionAfter);


        Assert.assertEquals(finaNumbertransactionAfterVal,finaNumbertransactionPrevVal.add(new BigDecimal(10)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterVal,finaNumberInterchangeDebitPrevVal.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalDebitAfterVal,finaNumberTotalDebitPrevVal.add(new BigDecimal(11)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterVal,finaNumberInterchangeCreditPrevVal.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalCreditAfterVal,finaNumberTotalCreditPrevValRoundup);
        Assert.assertEquals(finaNumberProcessingFeesAfter,finaNumberProcessingFeesRoundUp);
        Assert.assertEquals(finaNumberNetPositionAfter,finaNumberNetPosition.subtract(new BigDecimal(11)));
    }

    @Test
    public void Receive_Deposit_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //VOLUMES
        //Transactions
        String transactionPrevTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionPrevTrx = transactionPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionPrevTrx = new BigDecimal(finaltransactionPrevTrx);
        System.out.println("Transaction: " + finaNumberTransactionPrevTrx);

        //Interchange Debit
        String InterchangeDebitPrevTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitPrevTrx = InterchangeDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitPrevTrx = new BigDecimal(finalInterchangeDebitPrevTrx);
        System.out.println("Interchange Debit: " + finaNumberInterchangeDebitPrevTrx);

        //Total Debit
        String TotalDebitPrevTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitPrevTrx = TotalDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitPrevTrx = new BigDecimal(finalTotalDebitPrevTrx);
        System.out.println("Total Debit: " + finaNumberTotalDebitPrevTrx);

        //Interchange Credit
        String InterchangeCreditPrevTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditPrevTrx = InterchangeCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditPrevTrx = new BigDecimal(finalInterchangeCreditPrevTrx);
        System.out.println("Interchange Credit: " + finaNumberInterchangeCreditPrevTrx);

        //Total Credit
        String TotalCreditPrevTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditPrevTrx = TotalCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditPrevTrx = new BigDecimal(finalTotalCreditPrevTrx);
        System.out.println("Total Credit: " + finaNumberTotalCreditPrevTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String transactionPrevVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionPrevVal = transactionPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionPrevVal = new BigDecimal(finaltransactionPrevVal);
        System.out.println("Transaction: " + finaNumbertransactionPrevVal);

        //InterChange Debit Value
        String InterchangeDebitPrevVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitPrevVal = InterchangeDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitPrevVal = new BigDecimal(finalInterchangeDebitPrevVal);
        System.out.println("Interchange Debit Value: " + finaNumberInterchangeDebitPrevVal);

        //Total Debit
        String totalDebitPrevVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitPrevVal = totalDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitPrevVal = new BigDecimal(finalTotalDebitPrevVal);
        System.out.println("Total Debit Value: " + finaNumberTotalDebitPrevVal);

        //Interchange Credit
        String InterchangeCreditPrevVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditPrevVal = InterchangeCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditPrevVal = new BigDecimal(finalInterchangeCreditPrevVal);
        System.out.println("Interchange Credit Value: " + finaNumberInterchangeCreditPrevVal);

        //Total Credit
        String TotalCreditPrevVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditPrevVal = TotalCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditPrevVal = new BigDecimal(finalTotalCreditPrevVal);
        BigDecimal finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevVal.add(new BigDecimal(203.5));
        finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevValRoundup.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println("Total Credit Value: " + finaNumberTotalCreditPrevVal);

        //Processing Fees
        String ProcessingFees = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFees = ProcessingFees.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFees = new BigDecimal(finalProcessingFees);
        BigDecimal finaNumberProcessingFeesRoundUp = finaNumberProcessingFees.add(new BigDecimal(1));
        finaNumberProcessingFeesRoundUp = finaNumberProcessingFeesRoundUp.setScale(1,BigDecimal.ROUND_HALF_UP);
        System.out.println("Processing Fees Value: " + finaNumberProcessingFees);

        //Net Position
        String NetPosition = meezaReportPage.getNetPositionPrevValue();
        String finalNetPosition = NetPosition.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPosition = new BigDecimal(finalNetPosition);
        System.out.println("Net Position Value: " + finaNumberNetPosition);

        deposit.Receive_Deposit();
        deposit.Receive_Deposit_OffUs_Advice();
        refresh();

        //VOLUMES After
        //Transactions
        String transactionAfterTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionAfterTrx = transactionAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionAfterTrx = new BigDecimal(finaltransactionAfterTrx);

        //Interchange Debit
        String InterchangeDebitAfterTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitAfterTrx = InterchangeDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitAfterTrx = new BigDecimal(finalInterchangeDebitAfterTrx);

        //Total Debit
        String TotalDebitAfterTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitAfterTrx = TotalDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitAfterTrx = new BigDecimal(finalTotalDebitAfterTrx);

        //Interchange Credit
        String InterchangeCreditAfterTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditAfterTrx = InterchangeCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditAfterTrx = new BigDecimal(finalInterchangeCreditAfterTrx);

        //Total Credit
        String TotalCreditAfterTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditAfterTrx = TotalCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditAfterTrx = new BigDecimal(finalTotalCreditAfterTrx);


        Assert.assertEquals(finaNumberTransactionAfterTrx,finaNumberTransactionPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterTrx,finaNumberInterchangeDebitPrevTrx.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalDebitAfterTrx,finaNumberTotalDebitPrevTrx.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterTrx,finaNumberInterchangeCreditPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalCreditAfterTrx,finaNumberTotalCreditPrevTrx.add(new BigDecimal(1)));


        //Get Values
        meezaReportPage.clickValues();

        //Values After
        //Transactions
        String transactionAfterVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionAfterVal = transactionAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionAfterVal = new BigDecimal(finaltransactionAfterVal);

        //InterChange Debit Value
        String InterchangeDebitAfterVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitAfterVal = InterchangeDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitAfterVal = new BigDecimal(finalInterchangeDebitAfterVal);

        //Total Debit
        String totalDebitAfterVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitAfterVal = totalDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitAfterVal = new BigDecimal(finalTotalDebitAfterVal);

        //Interchange Credit
        String InterchangeCreditAfterVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditAfterVal = InterchangeCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditAfterVal = new BigDecimal(finalInterchangeCreditAfterVal);

        //Total Credit
        String TotalCreditAfterVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditAfterVal = TotalCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditAfterVal = new BigDecimal(finalTotalCreditAfterVal);

        //Processing Fees
        String ProcessingFeesAfter = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFeesAfter = ProcessingFeesAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFeesAfter = new BigDecimal(finalProcessingFeesAfter);

        //Net Position
        String NetPositionAfter = meezaReportPage.getNetPositionPrevValue();
        String finalNetPositionAfter = NetPositionAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPositionAfter = new BigDecimal(finalNetPositionAfter);


        Assert.assertEquals(finaNumbertransactionAfterVal,finaNumbertransactionPrevVal.add(new BigDecimal(200)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterVal,finaNumberInterchangeDebitPrevVal.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalDebitAfterVal,finaNumberTotalDebitPrevVal.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterVal,finaNumberInterchangeCreditPrevVal.add(new BigDecimal(3.5)));
        Assert.assertEquals(finaNumberTotalCreditAfterVal,finaNumberTotalCreditPrevValRoundup);
        Assert.assertEquals(finaNumberProcessingFeesAfter,finaNumberProcessingFeesRoundUp);
        Assert.assertEquals(finaNumberNetPositionAfter,finaNumberNetPosition.add(new BigDecimal(203.5)));
    }

    @Test
    public void Send_Deposit_OffUs() throws IOException, ParseException {
        loginPage.setUsername(ExcelFileManager.setDataFromExcelFile(0, 1));
        loginPage.setPassword(ExcelFileManager.setDataFromExcelFile(1, 1));
        loginPage.clickSignIn();
        loginPage.setOTP(ExcelFileManager.setDataFromExcelFile(2, 1));
        loginPage.clickVerifyOTP();
        meezaReportPage.clickReports();
        meezaReportPage.clickMeezaReport();

        //VOLUMES
        //Transactions
        String transactionPrevTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionPrevTrx = transactionPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionPrevTrx = new BigDecimal(finaltransactionPrevTrx);
        System.out.println("Transaction: " + finaNumberTransactionPrevTrx);

        //Interchange Debit
        String InterchangeDebitPrevTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitPrevTrx = InterchangeDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitPrevTrx = new BigDecimal(finalInterchangeDebitPrevTrx);
        System.out.println("Interchange Debit: " + finaNumberInterchangeDebitPrevTrx);

        //Total Debit
        String TotalDebitPrevTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitPrevTrx = TotalDebitPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitPrevTrx = new BigDecimal(finalTotalDebitPrevTrx);
        System.out.println("Total Debit: " + finaNumberTotalDebitPrevTrx);

        //Interchange Credit
        String InterchangeCreditPrevTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditPrevTrx = InterchangeCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditPrevTrx = new BigDecimal(finalInterchangeCreditPrevTrx);
        System.out.println("Interchange Credit: " + finaNumberInterchangeCreditPrevTrx);

        //Total Credit
        String TotalCreditPrevTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditPrevTrx = TotalCreditPrevTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditPrevTrx = new BigDecimal(finalTotalCreditPrevTrx);
        System.out.println("Total Credit: " + finaNumberTotalCreditPrevTrx);

        //Get Values
        meezaReportPage.clickValues();

        //Values
        //Transactions
        String transactionPrevVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionPrevVal = transactionPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionPrevVal = new BigDecimal(finaltransactionPrevVal);
        System.out.println("Transaction: " + finaNumbertransactionPrevVal);

        //InterChange Debit Value
        String InterchangeDebitPrevVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitPrevVal = InterchangeDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitPrevVal = new BigDecimal(finalInterchangeDebitPrevVal);
        System.out.println("Interchange Debit Value: " + finaNumberInterchangeDebitPrevVal);

        //Total Debit
        String totalDebitPrevVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitPrevVal = totalDebitPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitPrevVal = new BigDecimal(finalTotalDebitPrevVal);
        System.out.println("Total Debit Value: " + finaNumberTotalDebitPrevVal);

        //Interchange Credit
        String InterchangeCreditPrevVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditPrevVal = InterchangeCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditPrevVal = new BigDecimal(finalInterchangeCreditPrevVal);
        System.out.println("Interchange Credit Value: " + finaNumberInterchangeCreditPrevVal);

        //Total Credit
        String TotalCreditPrevVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditPrevVal = TotalCreditPrevVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditPrevVal = new BigDecimal(finalTotalCreditPrevVal);
        BigDecimal finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevVal.add(new BigDecimal(0));
        finaNumberTotalCreditPrevValRoundup = finaNumberTotalCreditPrevValRoundup.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println("Total Credit Value: " + finaNumberTotalCreditPrevVal);

        //Processing Fees
        String ProcessingFees = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFees = ProcessingFees.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFees = new BigDecimal(finalProcessingFees);
        BigDecimal finaNumberProcessingFeesRoundUp = finaNumberProcessingFees.add(new BigDecimal(0));
        finaNumberProcessingFeesRoundUp = finaNumberProcessingFeesRoundUp.setScale(1,BigDecimal.ROUND_HALF_UP);
        System.out.println("Processing Fees Value: " + finaNumberProcessingFees);

        //Net Position
        String NetPosition = meezaReportPage.getNetPositionPrevValue();
        String finalNetPosition = NetPosition.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPosition = new BigDecimal(finalNetPosition);
        System.out.println("Net Position Value: " + finaNumberNetPosition);

        deposit.Send_Deposit();
        deposit.Send_Deposit_Advice();
        refresh();

        //VOLUMES After
        //Transactions
        String transactionAfterTrx = meezaReportPage.getTransactionPrevTrx();
        String finaltransactionAfterTrx = transactionAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTransactionAfterTrx = new BigDecimal(finaltransactionAfterTrx);

        //Interchange Debit
        String InterchangeDebitAfterTrx = meezaReportPage.getInterchangeDebitPrevTrx();
        String finalInterchangeDebitAfterTrx = InterchangeDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeDebitAfterTrx = new BigDecimal(finalInterchangeDebitAfterTrx);

        //Total Debit
        String TotalDebitAfterTrx = meezaReportPage.getTotalDebitTrx();
        String finalTotalDebitAfterTrx = TotalDebitAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalDebitAfterTrx = new BigDecimal(finalTotalDebitAfterTrx);

        //Interchange Credit
        String InterchangeCreditAfterTrx = meezaReportPage.getInterchangeCreditTrx();
        String finalInterchangeCreditAfterTrx = InterchangeCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberInterchangeCreditAfterTrx = new BigDecimal(finalInterchangeCreditAfterTrx);

        //Total Credit
        String TotalCreditAfterTrx = meezaReportPage.getTotalCreditPrevTrx();
        String finalTotalCreditAfterTrx = TotalCreditAfterTrx.replaceAll(",", "");
        BigDecimal finaNumberTotalCreditAfterTrx = new BigDecimal(finalTotalCreditAfterTrx);


        Assert.assertEquals(finaNumberTransactionAfterTrx,finaNumberTransactionPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterTrx,finaNumberInterchangeDebitPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberTotalDebitAfterTrx,finaNumberTotalDebitPrevTrx.add(new BigDecimal(1)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterTrx,finaNumberInterchangeCreditPrevTrx.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalCreditAfterTrx,finaNumberTotalCreditPrevTrx.add(new BigDecimal(0)));


        //Get Values
        meezaReportPage.clickValues();

        //Values After
        //Transactions
        String transactionAfterVal = meezaReportPage.getTransactionPrevValue();
        String finaltransactionAfterVal = transactionAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumbertransactionAfterVal = new BigDecimal(finaltransactionAfterVal);

        //InterChange Debit Value
        String InterchangeDebitAfterVal = meezaReportPage.getInterchangeDebitPrevValue();
        String finalInterchangeDebitAfterVal = InterchangeDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeDebitAfterVal = new BigDecimal(finalInterchangeDebitAfterVal);

        //Total Debit
        String totalDebitAfterVal = meezaReportPage.getTotalDebitValue();
        String finalTotalDebitAfterVal = totalDebitAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalDebitAfterVal = new BigDecimal(finalTotalDebitAfterVal);

        //Interchange Credit
        String InterchangeCreditAfterVal = meezaReportPage.getInterchangeCreditValue();
        String finalInterchangeCreditAfterVal = InterchangeCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberInterchangeCreditAfterVal = new BigDecimal(finalInterchangeCreditAfterVal);

        //Total Credit
        String TotalCreditAfterVal = meezaReportPage.getTotalCreditPrevValue();
        String finalTotalCreditAfterVal = TotalCreditAfterVal.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberTotalCreditAfterVal = new BigDecimal(finalTotalCreditAfterVal);

        //Processing Fees
        String ProcessingFeesAfter = meezaReportPage.getProcessingFeesPrevValue();
        String finalProcessingFeesAfter = ProcessingFeesAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberProcessingFeesAfter = new BigDecimal(finalProcessingFeesAfter);

        //Net Position
        String NetPositionAfter = meezaReportPage.getNetPositionPrevValue();
        String finalNetPositionAfter = NetPositionAfter.replaceAll(",", "").replaceAll("EGP", "");
        BigDecimal finaNumberNetPositionAfter = new BigDecimal(finalNetPositionAfter);


        Assert.assertEquals(finaNumbertransactionAfterVal,finaNumbertransactionPrevVal.add(new BigDecimal(100)));
        Assert.assertEquals(finaNumberInterchangeDebitAfterVal,finaNumberInterchangeDebitPrevVal.add(new BigDecimal(2.5)));
        Assert.assertEquals(finaNumberTotalDebitAfterVal,finaNumberTotalDebitPrevVal.add(new BigDecimal(102.5)));
        Assert.assertEquals(finaNumberInterchangeCreditAfterVal,finaNumberInterchangeCreditPrevVal.add(new BigDecimal(0)));
        Assert.assertEquals(finaNumberTotalCreditAfterVal,finaNumberTotalCreditPrevValRoundup);
        Assert.assertEquals(finaNumberProcessingFeesAfter,finaNumberProcessingFeesRoundUp);
        Assert.assertEquals(finaNumberNetPositionAfter,finaNumberNetPosition.subtract(new BigDecimal(102.5)));
    }
}

/*
*@desription 			 : this testclass is used to verify the AccountBeforeDelete trigger
*@author    			 : Alexis Masson
*@date      			 : 18/09/2018
*@test class (trigger)   : AccountBeforeDelete
**/ 
@isTest(SeeAllData=false)
public class AccountBeforeDelete_Test {
    @testSetup
    public static void CreateAccounts() {
        List<Account> listAccounts = new List<Account>();
        for(Integer i=0;i<200;+i++) { // 200 for batch testing
            Account newAcc = new Account(Name='' + i);
            listAccounts.add(newAcc);
        }
        insert listAccounts;
    }
    
    @isTest
    public static void AccountDeletion() {
        // ligne suivante desuette si la classe DataFactory n'est pas importée : https://github.com/dhoechst/Salesforce-Test-Factory
    	// Account ac = (Account) DataFactory.createSObject(new Account(), 'DataFactory.AccountDefaults', true);
        List<Account> listAccounts = [SELECT Id from Account ORDER BY Id LIMIT 200];
        //System.debug('listAccounts.size(): '+ listAccounts.size());
        Test.startTest();
        {
			database.delete(listAccounts);
        }
        Test.stopTest();
    }
}
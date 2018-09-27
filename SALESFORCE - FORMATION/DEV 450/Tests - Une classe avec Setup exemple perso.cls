// SUJET POSTE POUR UNE QUESTION ICI :
//  https://salesforce.stackexchange.com/questions/232943/test-datas-a-issue-with-ids


@isTest(SeeAllData=false)
public class AccountProcessorTest {
    @testSetup
    Public static void CreateSetSobjects() {
        // creating and isnerting two account
        Account acc = new Account(Name='Acc Test 1');
        Account acc2 = new Account(Name='Acc Test 2');
        List<Account> lAcc = new List<Account>{acc, acc2};
		insert lAcc;
        
        // Contacts for Acc - linked by accountId to acc.id
        Contact con = new Contact(LastName='Contact 1 pour Acc1', accountId=acc.id);
        Contact con2 = new Contact(LastName='Contact 2 pour Acc1', accountId=acc.id);
        Contact con3 = new Contact(LastName='Contact 3 pour Acc1', accountId=acc.id);
        
        // Contact for Acc2 - linked by accountId to acc2.id
        Contact conAcc2 = new Contact(LastName='Contact 1 pour Acc2', accountId=acc2.id);
        
        List<Contact> lCon = new List<Contact>{con, con2, con3, conAcc2};
        insert lCon;
    }
    
    @isTest(SeeAllData=false)
    public static void AccountProcessor() {
        List<Id> lIds = new List<Id>();
        
        for(Account a: [SELECT Id, Name From Account]) {
            System.debug('AccountName : ' + a.Name);
            
            for(contact con : [SELECT Id, Name FROM Contact WHERE accountId = :a.id]){
                // I Can't enter THERE !
                System.debug('-------Contact lié : ' + con.name + ' -- ' + con.id);
            }
            lIds.add(a.id);
            System.debug('Liste rentree en test contient : ' + a.id);
        }
        Test.startTest();
        AccountProcessor.countContacts(lIds);
        Test.stopTest();
        
    }
    
    @isTest(SeeAllData=false)
    public static void printingEverything(){
        System.debug('TOTAL ACCOUNTS ' + [SELECT Id From Account].size() + ' Accounts.');
        System.debug('TOTAL CONTACTS ' + [SELECT Id From Contact].size() + ' Contacts.');
        
        for(Account acc : [SELECT Id, Name, (SELECT Id, Name FROM Contacts)
                           FROM Account]) {
            system.debug('Account name : ' + acc.Name);
            system.debug('Account Id : ' + acc.id);
			system.debug('-----------------------------ACCOUNTS');
        }
        for(Contact con : [SELECT Id, accountId, Name, account.name FROM Contact]) {
            system.debug('Contact Id : ' + con.id);
            system.debug('Contact accountId : ' + con.accountId);
            system.debug('Contact Name : ' + con.Name);
            system.debug('Account of the Contact : ' + con.account.name);
            system.debug('-----------------------------CONTACTS');
        }
    }
}
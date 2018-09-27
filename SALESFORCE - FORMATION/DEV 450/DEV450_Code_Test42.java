public class Test_42 {

    // tests sur les maps et acces aux donnees
    Public static void TestMap() {
        
        Map<String, Integer> maMap = new Map<String, Integer>();
        maMap.put('EElexis', 3);
        maMap.put('EElexis', 1);
        maMap.put('EElexis', 5);
        maMap.put('EElexis', 51);
        maMap.put('Michels', 8);
        maMap.put('Arthur', 23);
        
        String mot = 'EElexis';

        for(Integer i=0; i<=maMap.size(); i++) {
            // renvoyer le nombre d'occurences d'un element dans maMap :
            System.debug(
                (maMap.containsKey(mot)?
                 maMap.get(mot):
                 0));

        }
    }
    
    // tests sur listes et SOQL
    Public static void InitSOQL() {
        
        String prenom='Alexis';
        String query ='SELECT FirstName, LastName, ID FROM Contact Where firstname =\'' + prenom + '\' LIMIT 3';
        System.Debug('Query : ' + query);

        List<Contact> maListe = [SELECT FirstName, LastName, ID FROM Contact Where firstname='Alexis' LIMIT 3];
        // List<Contact> maListe2 = new List<Contact> (query ); 
        System.Debug('Taille de la liste récupérée : ' + maListe.size());
        System.Debug('Nom, prénom de la gamme : ' + maListe.get(0).firstName + ' ,' + maListe[0].lastName);
    }
    
    // tests sur listes et SOQL
    Public static void InitSQL2() {
        // on boucle sur des contacts, en fait une liste de sObjects, donc
        //  une sorte de liste de tableaux
        List<Contact> maListe = new List<Contact> ([SELECT ID, AccountId, Account.name
                                                   FROM Contact]);
        System.Debug('Taille liste : ' + maliste.size());
        For(Integer i=maliste.size()-1; i>= 0 ;i--) {
            System.Debug('maListe(' + i + ') : ' + maListe[i]);
        }
    }

    // DEV450 officiel - Exemple de base sur les relationship
    Public static void DEV450_RelationShip () {
        // on recupere un contact via SOQL
        Contact contactToChange = [SELECT AccountID, account.Name
                                  FROM contact
                                  LIMIT 1];
        // on stocke son accountID
        // Referencing father from child
        Id oldAccountId = contactToChange.AccountID;
        Account oldAccount = contactToChange.Account;
        String accountName = contactToChange.Account.Name;
    }
    
    // DEV450 - Exercice Custom Relationship Exemple Attempts
    Public static void DEV450_CustomRelationShip () {
        course__c courseToChange = [SELECT Certification__c, certification__r.name
                                   FROM Course__c
                                   LIMIT 1];
        
         // ca je comrpends pas trop ... C'est donc un ID déjà ? --> OUI 
         // car le champ lookup contient directement la valeur de l'ID !
        ID oldCertificationId = courseToChange.Certification__c;
        Certification__c oldCertification = courseToChange.Certification__r;
        String certificationName = oldCertification.name;
        System.Debug('Nom certif : ' + certificationName);
    }
    
    // DEV450 - P 1330 - Exercice Custom Relationship Exercice Attempts
    Public static void DEV450_p130_CustomRelationShip_Ex () {
        List<Certification_Attempt__c> oldCertAttempts = [SELECT Id, Name,					    // 1 name of the certif_attempt
                                                          Certification_Element__c, 				    // 2 parent Certif Element's ID
                                                          Certification_Element__r.Name, 		        // 3 parent Certif Element's name
                                                          Certification_Candidate__r.Name,        // 4 parent Contact's name
                                                          Certification_Candidate__r.Account.Name,  // 5 parent Contact's associated Account Name
                                                          Certification_Element__r.certification__r.Name,
                                                          Status__c
                                                         FROM Certification_Attempt__c 
                                                         WHERE Status__c ='Scheduled'];			 // 6 Status = scheduled
        Integer count = 0;
        for (Certification_Attempt__c CertAtt : oldCertAttempts) {
            count++;
            System.debug('Tentative numero : ' + count);
            System.debug('Nom de la certif : ' + CertAtt.Certification_Element__r.certification__r.Name);
            System.debug('Name Certif_ATTEMPT : ' + CertAtt.Name); // 1
            System.debug('Element parent : id ' + CertAtt.Certification_Element__c); // 2
            System.debug('parent Certif Element\'s name : ' + CertAtt.Certification_Element__r.Name); // 3
            System.debug('Nom du candidat : ' + CertAtt.Certification_Candidate__r.Name); // 4
            System.debug('parent Contact\'s associated Account Name : ' + CertAtt.Certification_Candidate__r.Account.Name); // 5
            System.debug('Status (doit être scheduled) : ' + CertAtt.Status__c);
            System.debug('-------------------------------');
        }
    }
    
    // DEV 450 - P 137 - Certif Attempt
    Public static void DEV450_p137_CertifAttempt () {
        // 1. What would correctly complete the final statement ?
        Certification_Attempt__c CertAttempt = [SELECT Id, Name, certification_Element__c, certification_Element__r.Name,
                                                certification_Element__r.certification__c,
                                                certification_Element__r.certification__r.name,
                                                certification_candidate__c,
                                                certification_candidate__r.Name
                                                FROM Certification_Attempt__c
                                                WHERE Name LIKE '%0152' // j'insiste sur le nom de l'attempt
                                                LIMIT 1]; // assume this populates from the database 
        
        // la string recupère du child 2 parent
        String certificationElementName = CertAttempt.certification_Element__r.Name;
        System.debug('Nom de la tentative : ' + CertAttempt.Name);
        System.debug('Id du candidat : ' + CertAttempt.certification_candidate__c);
        System.debug('Name du candidat : ' + CertAttempt.certification_candidate__r.name);
        System.debug('Nom de l\'element : ' + certificationElementName);
        // System.debug('Nom de l\'element : ' + CertAttempt.certification_Element__r.certification__r.Name); // marche pas ..
    	// System.debug('Id de la certification associée : ' + CertAttempt.certification_Element__r.certification__c);
        System.debug('Nom de la certification associée : ' + CertAttempt.certification_Element__r.certification__r.Name);
        
        // 2. What would correctly complete the final statement ?
        Certification_Element__c certElement =  [SELECT Id, Name FROM Certification_Element__c LIMIT 1]; // assume this populates from the database 
        List <Certification_Attempt__c> certifAttempts = certElement.certification_Attempts__r;
        // System.debug('Nom de certElement (retourne par query) : ' + certElement.name);
        
        for (Certification_Attempt__c c : certifAttempts) {
            System.debug('Nom de certElement (retourne par query) : ' + c.name);
		}
        
        //3 What conditional expression would be used to determine if the contents
        // of 2 sObjects are equals ?
        
    }
    
    // exercice Custom Relationship mother of child
    Public static void TestRelationShip () {
        //This query returns the ID and first name of daughter objects
        //and the first name of the daughter's mother 
        //if the mother's last name begins with 'C.'
        /*
         List<Daughter__c> DList= [SELECT Id, FirstName__c, MotherOfChild__r.firstName__c
                 FROM Daughter__c
				 WHERE MotherOfChild__r.LastName__c LIKE 'C%'];
        */
        /*
        List <Daughters__c> listeMother = new List<Daughters__c> ();
        listeMother = [SELECT ID, firstName__c,
                      	(SELECT firstName__c
                         FROM mother_of_child__r
						 WHERE mother_of_child__r.lastName LIKE 'C%')
                      FROM Daughters__c];
        */
        /* Correction : SELECT Id, FirstName__c, Mother_of_Child__r.FirstName__c
			FROM Daughter__c
			WHERE Mother_of_Child__r.LastName__c LIKE 'C%'*/
    }
    
    // exercice Custom Relationship
    public static void autreExerciceRelationCustom () {
        /* SELECT Id, FirstName, LastName, AccountId, Account.Name
         * FROM Contact
		 * WHERE Account.Name LIKE 'Acme%' */
        
        String nomCompte='Acme%';
        
        // Mis sous forme FROM account (sous requete) :
        List <Account> AccList = new List<Account> (
            [SELECT ID, Name,
             (SELECT ID, Firstname, LastName
              FROM contacts)
             FROM account
             WHERE Name LIKE 'Acme%']);
        // affichage des resultats :
        System.Debug('Nombre de comptes contnant : ' + nomCompte + ' : ' + accList.size());
        For(Integer i=0;i<=accList.size()-1;i++) {
            System.Debug('accList[' + i + '] : ' + AccList[i]);
		}
    }
    
    // DEV 450 - P 167 - Query at run time (avec un param dynamic)
    Public static void DEV450_p167_DynamicSOQL () {
        String criteria = '';
        Boolean lookForOpenCases = false;
        If (lookForOpenCases==true) {
            criteria = 'Status = \'Working\'';
        } else {
            criteria = 'ClosedDate < TODAY';
        }
        
        List <Case> theCases = Database.query('SELECT Id, Subject FROM Case Where ' + criteria);
        System.debug('The Cases : ' + theCases);
    }
    
    // tests d'insert en base
    // On montre que le (seul) RequiredField pour insert CONTACT est LASTNAME !!
    // On montre que le (seul) RequiredField pour insert ACCOUNT est NAME !!
    Public static void Entrainement_SOQL_Insert () {
        Contact cont = new Contact(LastName='Monsieur Poulpe', firstName='Ah ah');
        // insert cont;
        System.debug('Contact insere en base : ' + cont);
        Account acc = new Account(Name='Mon Account Test');
        //insert acc;
        System.debug('Account insere en base : ' + acc);        
    }
    
    // DEV450 - P184 - AllChildrenCustomRelationship
    Public static void DEV450_p184_AllChildrenCustomRelationship () {
        List<Course__c> CourseList = new List<Course__c> ([
            SELECT Name, Certification__c, Certification__r.name, Certification__r.Certification_Description__c FROM Course__c]);
        For (Course__c course : CourseList) {
            System.debug('--------------');
            System.debug('Cours : ' + course);
            // System.debug('Cours : ' + course.certification__r.certification_element__r.Name);
        }
    }
        
    // exemple DataBase SaveResult
    Public static void Exemple_DataBase_SaveResult () {
        // On montre que Database.insert(parm1, param2) a pour param2 TRUE par defaut
		// creation d'une liste de contacts
        List <Contact> ConList = new List <Contact>{new Contact(LastName='Massal', firstName='Douduoz'),
            										new Contact(LastName='Massal10', firstName='Doudouz deux')};
		conList.add(new Contact(firstName='Graoul'));
        
        // on insert avec AllOrNone = false
        // SI ON OMET LE SECOND PARAM, alors EXCEPTION
        // Par defaut, on verifie bien qu'il vaut TRUE
        Database.SaveResult[] sr = Database.insert(conList, false);
        
        // loop sur la condition d'insert :
        for (Database.SaveResult sResult : sr) {
            if(sResult.isSuccess()) {
                System.debug('Objet insere en base : ' + sResult);
            } else {
                System.debug('Objet NON insere en base : ' + sResult);
            }
        }
    }
    
    // DEV 450 - P 186 - SOQL For loop exercice
    public static void DEV450_P186_SOQLForLoop () {
        
        String req = 'SELECT Name, Account.Name FROM CONTACT';
        // voici comment remplir une List avec une query !
		List <Contact> conList =  Database.query(req); 			// new List <Contact> ([SELECT Name, Account.Name FROM CONTACT]);
        for (Contact con : conList) {
			System.debug('Contact : ' + con.Name + '& related Account : ' + con.account.name);            
        }
    }
    
    // DEV 450 - P 192 - Subrequests
    public static void DEV450_P192_SOQL_Subqueries () {
        // this query selects only certifs that have courses related

		// String req0 = 'SELECT name FROM Certification__c WHERE ID IN (SELECT Certification__c from Course__c)';
        String req = 'SELECT name, (SELECT NAME FROM courses__r) FROM Certification__c WHERE ID IN (SELECT Certification__c from Course__c)';
        
        Integer count = 0;
        List<Certification__c> CertList = Database.query(req);
        // boucle sur les certification__c
        // on devrait verifier que CertList.size() > 0 mais flemme
        for(Certification__c certif : CertList) {
			System.debug('----');count++;
            System.debug('Certification ' + count + ' : ' + certif);
            // System.debug('Nombre de courses dans certif : ' + certif.courses__r.size()); // pas bien !!
            
            // deuxieme boucle pour preserver la heap size
            for (Course__c course : certif.Courses__r) {
                System.debug('Nom du cours : ' + course.name);
            }
        }
    }
    
    // DEV 450 - P 193 - Ex 6.2 Nested requests - Parent 2 child - PART 1
    public static void DEV450_P193_SOQL_NestedQueries_Parent2Child_Part1 () {
        // Select all accounts and display their names
        // + lastName of any related Contact
        List <Account> accList = [SELECT Name, (SELECT lastName FROM Contacts) FROM Account];
        
        for (Account acc : accList) {
            System.debug('Account : Nom : ' + acc.name);
            for (contact con : acc.contacts) {
                System.debug('Account : lastName des contacts associés :) ' + con.lastName);
            }
        }
    }     
    
	// DEV 450 - P 193 - Ex 6.2 Nested requests - Parent 2 child - PART 2
    public static void DEV450_P193_SOQL_NestedQueries_Parent2Child_Part2 () {    
        // Select all certifications that have a related Course
        // Write a single query that selects only Certifs with an associated course
        // Be sure to also select  the Name of the Course__c
        
        // dans la sous requête, attention : on interroge la RELATION Courses__r
        String selectClause = 'SELECT Name, (SELECT Name FROM Courses__r) ';
        String fromClause = 'FROM Certification__c ';
        String whereClause = 'WHERE Id IN (SELECT Certification__c FROM Course__c)';
        String req =  selectClause + fromClause + whereClause;

        List <Certification__c> certList = Database.query(req);
        
        For (Certification__c cert : certList) {
            System.debug('Certif (nom): ' + cert.name);
            for (Course__c course : cert.courses__r) {
                System.debug('Cours de cette certif (nom): ' + course.name);
            }
        }
    }
    
    // DEV 450 - P 201 - APEX DML- Saving Changes to Contacts
    public static void DEV450_P201_APEX_DML_SavingChangestoContacts () {
        // Fetch rows from DB
		List <Contact> oldLeadSourceContacts =
            [SELECT LeadSource, Name
             FROM Contact
			 WHERE LeadSource ='Trade Show'];
        
        // update fetched rows in memory
        Set<Id> oldLeadSourceContactsIds = new Set<Id>();
        for(Contact con : oldLeadSourceContacts) {
            con.LeadSource = 'Other';
            oldLeadSourceContactsIds.add(con.Id);
        }
        
        // PERSIST UPDATES TO DB (DML)
        update oldLeadSourceContacts;
        // Database.SaveResult[] sr = Database.update(oldLeadSourceContacts, false);

        // Fetche the updated rows from DB
		List <Contact> updatedLeadSourceContacts = 
            [SELECT LeadSource
             FROM Contact
             WHERE Id IN :oldLeadSourceContactsIds];
        
        for(Contact con : updatedLeadSourceContacts) {
			if (con.LeadSource <> 'Other')
                // verify the updates
                System.debug('Update failed !');
        }
    }
    
    
    
    
    // DEV 450 - P 204 - APEX DML- Exemple VERSION REQUETE
    public static void DEV450_P204_APEX_DML () {
        // second contact won't work because LastName is required
        Contact withName = new Contact(LastName ='Dour');
        Contact noName = new Contact();
        List <Contact> conList = new List <Contact> {withName, noName, new Contact(LastName='Dernier Nom')};
        
		// persist : insert
		Database.SaveResult[] sr = Database.insert(ConList, false);
        
        // for loop sur les resultats
		for (Database.SaveResult saveR : sr) {
            if(saveR.isSuccess()) {
				System.Debug('DML insert ok for : ' + saveR);
                // 'Select Id, Name From ' + sobjectName + ' Where Id = :myId' ??
                // https://salesforce.stackexchange.com/questions/45380/get-sobject-by-id
				// SELECT Name FROM Contact WHERE Id =: saveR.id
                // TODO GERE ICI AL QUERY
                String req = 'SELECT Name FROM Contact WHERE Id =: saveR.id';
                List <sObject> sListeNom = [SELECT Name FROM Contact WHERE Id =: saveR.id];
                
                // String[] listNom = new String[] ([SELECT Name FROM Contact WHERE Id =: saveR.id]);
                
                // Contact con = Database.query(req);//'SELECT Name FROM Contact WHERE Id in :' + saveR.id);
                // System.debug('Name du contact : ' + con.name);
				// String sNom = (String) sListeNom[0];System.debug('Name du contact : ' + sListeNom[0]);
				System.debug('Name du contact : ' + sListeNom[0]);
            } else {
                System.Debug('Erreur : ' + saveR.getErrors());
            }
        }
    }
    
    
    
    
    
    // DEV 450 - P 204 - APEX DML- Exemple VERSION MAP
    public static void DEV450_P204_APEX_DML_VersionAvecMAP () {
        // this won't work because LastName is required
        Contact noName = new Contact(); 
        Contact withName = new Contact(LastName ='Dour');
        Contact CCCCCC = new Contact(); 
        Contact withName222 = new Contact(LastName ='Dour');

        // liste initiale
        List <Contact> conList = new List <Contact> {withName, noName, new Contact(LastName='DernierNom')};
        conList.add(CCCCCC);
        conList.add(withName222);
        System.assertEquals(5, conList.size(), 'ERREUR AU NIVEAU DE LA TAILLE DE LA LISTE');
        
		// instanciation d'une map Id Contact
        Map <Id, Contact> conMap = new Map <Id, Contact>();
        
        
		// Persist with database.SaveResult --> create the ID's !
		Database.SaveResult[] sr = Database.insert(conList, false);
        
        for(Contact con: conList) {
            if(con.Id != null) {
                conMap.put(con.Id, con);
            }
        }

		System.debug('--------------TAILLE DE LA MAP : ' + conMap.size());
        
		for (Database.SaveResult saveR : sr) {
            if(saveR.isSuccess()) {
                // get Id avec la map
                String nomAcc = conMap.get(saveR.getId()).name;//conMap.get(saveR.getId()).Name;
                System.debug('Name du contact : ' + nomAcc);
            } else {
                System.Debug('Erreur : ' + saveR.getErrors());
            }
        }
    }
    
    // REFAIS SEUL OK (OKLM)
    public Static Void Je_travaille_seul_au_burau () {
        
        // declaration d'une liste
        List <Account> AccList = new List <Account> {new Account(Name='BonjourAccount'),
            new Account()};
		Account Ac = new Account();
        Account Ac2 = new Account(Name='REQUIRED GARCON DOUR');
        Account Ac3 = new Account();
        
        // put des elements
        AccList.add(Ac);
        AccList.add(Ac2);
        AccList.add(Ac3);
        
        System.Debug('Taille de ma liste (5 ?) : ' + accList.Size());
        // System.assertEquals(6, accList.Size(), '--ERREUR PERSONNALISEE MON MESSAGE ICI--');
        
        // insert en SaveResult
        Database.saveResult[] sr = Database.insert(AccList, false);
        
        // boucle opur la map
        Map <Id, Account> accMap = new Map <Id, Account> ();
        Integer count=0;Integer countMap=0;
        for(Account acc : AccList){
            count++;System.debug('Interroge l\'account numero : ' + count);
            if(acc.Id != Null) {
                countMap++;
				accMap.put(acc.Id, acc);
                System.debug('MAPPAGE de : ' + acc);
                System.debug('TOTAL ACTUEL DANS LA MAP : ' + countMap);
            }
        }
        
        // tcheck et debug des results
        for (Database.SaveResult SavR : sr) {
            if (savR.isSuccess()==true) {
                // Debug du nom
                String nomAcc = accMap.get(SavR.getId()).Name;
                System.debug('Nom du compte :' + nomAcc);

                
            } else {
                System.Debug('savR.errors : ' + savR.errors + ' ------ ET AUSSI ----- ' + Savr.getErrors());
            }
        }
    }
    
    // DEV450_P213_CatchingExceptions
    Public Static Void DEV450_P213_CatchingExceptions() {
        List <Account> AccList = new List <Account> {
            new Account(Name='Acmerde'),
                new Account(),
                new account(Name='Trois Account')};
		// System.Debug('Taille liste (3) : ' + AccList.Size());
        System.assertEquals(3, AccList.Size(), '---Liste mal filled---');
            Try {
                insert accList;
                // database.insert(accList);
            } catch (DmlException dEx) {
                System.debug('---Erreur : ' + dEx.getMessage());
            }
    }
    
	// DEV450_P215_DatabaseSaveResults
    Public Static Void DEV450_P215_DatabaseSaveResults() {
        Contact withName = new Contact(LastName='NomContact');
        Contact noName = new Contact();
        Contact Name3 = new Contact(LastName='AlFonss');
        List <Contact> conList = new List<Contact> {withName, noName, new Contact(), Name3, new Contact()};
            
		// Insert en base
		List <Database.SaveResult> SRList = Database.insert(conList, false);
        
        // Loop
        For (Database.SaveResult sr : SRList) {
            if (!sr.isSuccess()) {
                List<Database.Error> LErrors = sr.getErrors();
            	
                // log errors
                // Pourquoi mettent ils une boucle ici ?
                Integer i = 0;
                for(Database.Error err : LErrors) {
                    System.debug('Erreurs : ' + err.getMessage());
                    System.debug('----');
                }
            }
        }
    }
    
	// DEV450_P216_HandleDMLErrorsAndExceptions
    Public Static Void DEV450_P216_HandleDMLErrorsAndExceptions() {
        // GOAL is to handle errors when inserting Contacts
    }

    // la methode appelle la methode suivante, marche tres bien
    public static ID addContact(String lastNameToInsert, String firstNameToInsert) {
        Contact contactToAdd = new Contact(FirstName=firstNameToInsert,
                                           LastName=lastNameToInsert);
        insert(contactToAdd);
        System.debug('contactToAdd recordID is: ' + contactToAdd.Id);
        Contact conT = ContactManager.chercheContactByID(contactToAdd.Id);
        System.debug('Nom contact : ' + conT.LastName);
        // test recup
        System.debug('Prenom contact : ' + conT.FirstName);
		System.debug('Name contact : ' + conT.Name);
        return contactToAdd.Id;
    }
    
    // fonction qui renvoie Salutation, Name, LastName, FirstName, Id d'un contact via son Id
    public static Contact chercheContactByID (Id id) {
        String req = 'SELECT Salutation, Name, LastName, FirstName FROM Contact WHERE id =\''+ id + '\' LIMIT 1';
        Contact con = Database.query(req);        
        return con;
    }

    public static void TestSchemaDescribe () {
        // methode issue de SF -> https://developer.salesforce.com/docs/atlas.en-us.apexcode.meta/apexcode/apex_dynamic_describeSObject.htm
        // sObject types to describe
        String[] types = new String[]{'Account','Contact', 'Broker__c'};
            
        // Make the describe call
        Schema.DescribeSobjectResult[] results = Schema.describeSObjects(types);
    
        // For each returned result, get some info
        for(Schema.DescribeSobjectResult res : results) {
            System.debug('---sObject Label: ' + res.getLabel());
            System.debug('---Number of fields: ' + res.fields.getMap().size());
            System.debug('---' + res.isCustom() ? 'This is a custom object.' : 'This is a standard object.');
            // Get child relationships
            Schema.ChildRelationship[] rels = res.getChildRelationships();
            if (rels.size() > 0) {
                System.debug(res.getName() + ' has ' + rels.size() + ' child relationships.');
            }
        }
    }
    
}
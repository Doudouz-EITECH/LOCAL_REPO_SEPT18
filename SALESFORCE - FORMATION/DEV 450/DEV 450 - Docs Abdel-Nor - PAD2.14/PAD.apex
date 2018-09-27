public class PAD{
private static final Set<String> requiredOnce=new Set<String>{'AP123','AP432'};//List of Apex codes that should run only once. Add any code to the list
private static Set<String>hasRun=new Set<String>();//List of Apex code that has already been run. Keep this list empty.
public static final String PAD_BypassTrigger;//List of triggers that can be bypassed
public static final Boolean PAD_DebugMode {get;set;}
public static final String userRoleName;  //User Role Name
public static final String userProfileName;//User Profile Name
public static Set<String> ApexForcedBypass=new Set<String>();//ex: 'AP123','AP432'//List of Apex codes that need to be bypassed, dynamically and temporaryly managed by Apex Code
static{
	System.Debug('## >>> PAD constructor :BEGIN <<< run by ' + UserInfo.getName());
	User user=[SELECT UserRole.Name,Profile.Name,UserPreferencesApexPagesDeveloperMode,PAD_BypassTrigger__c FROM User WHERE Id =:UserInfo.getUserId() LIMIT 1];
	PAD_BypassTrigger=';'+user.PAD_BypassTrigger__c+';';
	PAD_DebugMode=user.UserPreferencesApexPagesDeveloperMode;
	userRoleName= user.UserRole.Name;
	userProfileName = user.Profile.Name;
	System.Debug('## >>> PAD constructor : END <<<');
}
public static boolean canTrigger(String ApexName){//If no bypass
	if(requiredOnce.contains(ApexName)){//If it should run Once
		if(hasRun.contains(ApexName))return false;//Already run, should not run
		hasRun.add(ApexName);//Never run, can run only if not bypassed
	}
	return(PAD_BypassTrigger.indexOf(';'+ApexName+';')==-1 && !ApexForcedBypass.contains(ApexName));
}
/*Uncomment if you have activated multiple currency
	public static Double convertToCorporateCurrency(String currencyIsoCode, Double amount){
	if(!currencyRate.containsKey(currencyIsoCode))
		for(CurrencyType curType: [SELECT IsoCode, ConversionRate FROM CurrencyType WHERE IsActive=true])
		currencyRate.put(curType.IsoCode, curType.ConversionRate);
	return amount/currencyRate.get(currencyIsoCode);
}*/
/**********************
Visual Force part below
***********************/
public class PAD_log{//One log entry
	public String timer{get;set;}
	public String reason{get;set;}
	public String message{get;set;}
	public String rowCSS{get;set;}
	public PAD_log(String message,String reason){
		this.timer=DateTime.now().format('HH:mm:ss , SS\'ms\'');
		this.reason=reason;
		this.message=message;
	}
	public PAD_log(String message,String reason,String rowCSS){
		this.timer=DateTime.now().format('HH:mm:ss , SS\'ms\'');
		this.reason=reason;
		this.message=message;
		this.rowCSS=rowCSS;
	}
}
public static Long starter;
public static List<PAD_log>PAD_logs=new List<PAD_log>();
public static void startTimer(){
	starter=DateTime.now().getTime();
	log('<img src="/img/icon/custom51_100/stopwatch16.gif" width="16px" height="16px"');
}
public static void stopTimer(){if(starter!=null)log('<img src="/img/icon/custom51_100/stopwatch16.gif" width="16px" height="16px" /><i> '+String.ValueOf(DateTime.now().getTime()-starter)+' ms</i>');}
public static void log(String message,String reason,String rowColor){if(PAD_logs.size()<1000)PAD_logs.add(new PAD_log(message,reason,rowColor));}
public static void log(String message,String reason){if(PAD_logs.size()<1000)PAD_logs.add(new PAD_log(message,reason));}
public static void log(String message){if(PAD_logs.size()<1000)PAD_logs.add(new PAD_log(message,''));}
public static void log(Integer message){if(PAD_logs.size()<1000)PAD_logs.add(new PAD_log(String.valueOf(message),''));}
public static void log(Integer message,String reason){if(PAD_logs.size()<1000)PAD_logs.add(new PAD_log(String.valueOf(message),reason));}
public static void log(Integer message,Integer reason){if(PAD_logs.size()<1000)PAD_logs.add(new PAD_log(String.valueOf(message),String.valueOf(reason)));}
public static void log(String message,Integer reason){if(PAD_logs.size()<1000)PAD_logs.add(new PAD_log(message,String.valueOf(reason)));}
private static String myColor(Integer myFrom,Integer myTo){
	Decimal myPercent;
	if(myTo!=0)myPercent=(myFrom+0.0)/(myTo+0.0);
	else myPercent=0;
	if(myPercent>=0.8)return 'background-color:#B22222;color:white;font-weight:bold;';
	else if(myPercent>=0.5)return 'background-color:#FF7F00;color:white;font-weight:bold;';
	else return 'font-weight:bold;';
}
public static void limits(){
	log(Limits.getAggregateQueries()+' / '+Limits.getLimitAggregateQueries(),'AggregateQueries',myColor(Limits.getAggregateQueries(),Limits.getLimitAggregateQueries()));
	log(Limits.getCallouts()+' / '+Limits.getLimitCallouts(),'Callouts',myColor(Limits.getCallouts(),Limits.getLimitCallouts()));
	log(Limits.getDMLRows()+' / '+Limits.getLimitDMLRows(),'DMLRows',myColor(Limits.getDMLRows(),Limits.getLimitDMLRows()));
	log(Limits.getDMLStatements()+' / '+Limits.getLimitDMLStatements(),'DMLStatements',myColor(Limits.getDMLStatements(),Limits.getLimitDMLStatements()));
	log(Limits.getEmailInvocations()+' / '+Limits.getLimitEmailInvocations(),'EmailInvocations',myColor(Limits.getEmailInvocations(),Limits.getLimitEmailInvocations()));
	log(Limits.getFieldsDescribes()+' / '+Limits.getLimitFieldsDescribes(),'FieldsDescribes',myColor(Limits.getFieldsDescribes(),Limits.getLimitFieldsDescribes()));
	log(Limits.getFindSimilarCalls()+' / '+Limits.getLimitFindSimilarCalls(),'FindSimilarCalls',myColor(Limits.getFindSimilarCalls(),Limits.getLimitFindSimilarCalls()));
	log(Limits.getFutureCalls()+' / '+Limits.getLimitFutureCalls(),'FutureCalls',myColor(Limits.getFutureCalls(),Limits.getLimitFutureCalls()));
	log(Limits.getHeapSize()+' / '+Limits.getLimitHeapSize(),'HeapSize',myColor(Limits.getHeapSize(),Limits.getLimitHeapSize()));
	log(Limits.getQueries()+' / '+Limits.getLimitQueries(),'Queries',myColor(Limits.getQueries(),Limits.getLimitQueries()));
	log(Limits.getPicklistDescribes()+' / '+Limits.getLimitPicklistDescribes(),'PicklistDescribes',myColor(Limits.getPicklistDescribes(),Limits.getLimitPicklistDescribes()));
	log(Limits.getQueryRows()+' / '+Limits.getLimitQueryRows(),'QueryRows',myColor(Limits.getQueryRows(),Limits.getLimitQueryRows()));
	log(Limits.getSavepointRollbacks()+' / '+Limits.getLimitSavepointRollbacks(),'SavepointRollbacks',myColor(Limits.getSavepointRollbacks(),Limits.getLimitSavepointRollbacks()));   
	log(Limits.getSavepoints()+' / '+Limits.getLimitSavepoints(),'Savepoints',myColor(Limits.getSavepoints(),Limits.getLimitSavepoints()));
	log(Limits.getScriptStatements()+' / '+Limits.getLimitScriptStatements(),'ScriptStatements',myColor(Limits.getScriptStatements(),Limits.getLimitScriptStatements()));
	log(Limits.getSoslQueries()+' / '+Limits.getLimitSoslQueries(),'SoslQueries',myColor(Limits.getSoslQueries(),Limits.getLimitSoslQueries()));
}
public List<PAD_log>getPAD_logs(){return PAD_logs;}
static testMethod void PAD_Main_TestMethod(){
	PAD.log('','');PAD.log('',1);PAD.log(1,'');PAD.log(1,1);PAD.log(1);PAD.log('');PAD.startTimer();PAD.stopTimer();
	limits();
	myColor(0,0);myColor(0,3);myColor(2,3);myColor(3,3);PAD myPAD=new PAD();myPAD.getPAD_logs();
	PAD.canTrigger('AP123');
}
}
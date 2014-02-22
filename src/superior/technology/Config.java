package superior.technology;

public abstract interface Config {	
	
	// CREDENTIALS
	public static final String MYSQLID = "khzrfjky_admin";	
	public static final String MYSQLPSSD = "Bella2011";
	public static final String ENTRYGUARDDB = "khzrfjky_entryguard";		
	public static final String MYSQLURLLOCAL = "jdbc:mysql://localhost:3306/";
	public static final String MYSQLURL = "jdbc:mysql://www.entry-guard.com:3306/";
	public static final String LOGOLOCATION = "../assets/img/verifiedLogoNoShield.png";
	
	//HASHITERATION
	int hashIterations = 40005;
	
	//GENERIC
	public static final String CONTACTUSDIRECTLYMESSAGE = " Please contact us directly at webmaster@entry-guard.com, thank you.";
	public static final String SYSTEMISSUEMESSAGE = " due to system issue, please send us an email directly at webmaster@entry-guard.com.";
		
	//PIN
	//public static final String PINREQUESTSQL = "INSERT INTO registrations (registrationPin, registrationEmailAddress, _updatedAt, _createdAt) VALUES (?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
	public static final String PINREQUESTSQL = "INSERT INTO registrations (registrationPin, registrationEmailAddress, _updatedAt, _createdAt) VALUES (?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)"; // ON DUPLICATE KEY UPDATE registrationPin=?, _updatedAt=CURRENT_TIMESTAMP"
	public static final String FAILEDPINA = ", your PIN request failed because a PIN was already requested. If you have misplaced your PIN number please contact us directly at webmaster@entry-guard.com, thank you.";
	public static final String FAILEDPINB = ", your PIN was created successfully, however, your PIN email was not sent";
	public static final String FAILEDPIN = ", please send us an email through the contact us link so we can send your pin immmediately.";
	public static final String SUCCESSPINA = "PIN request was successful for user ";
	public static final String SUCCESSPIN = ", please check your email and use the sent PIN to register with us.";
	
	// REGISTRATION	
	public static final String REGISTERLOOKUPSQL = "SELECT 1 FROM registrations where registrationEmailAddress=? and registrationPin=?";
	

	public static final String FAILEDREGISTRATION = "Registration failed for user ";
	public static final String FAILEDNOREGISTRATIONDUP = ", please request a new PIN. If you believe this message is in error send us an email through the contact us link.";
	public static final String FAILEDENDREGISTRATIONDUP = ", you are already registered. If you cannot recall your email or password please send us an email through the contact us link.";
	public static final String FAILEDENDREGISTRATIONSYS = ", please send us an email through the contact us link with the error message observed.";
	public static final String SUCCESSREGISTRATION = "Registration was successful for user ";
	public static final String SUCCESSENDREGISTRATION = ", please use the registered email and password to sign in.";
	
	//CONTACTFORM
	public static final String CONTACTFORMINSERTSQL = "INSERT INTO messages (preferredName, subject, email1, message, _createdAt) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
	public static final String FAILEDCONTACTFORMMESSAGE = " your message delivery was unsuccessful, possibly a system problem. " + CONTACTUSDIRECTLYMESSAGE;
	public static final String SUCCESSCONTACTFORMMESSAGE = " your message was successfully delivered, we will get back to you as soon as we can.";
	public static final String CONTACTSELECTSQL = "SELECT _createdAt, contactMade, contactMadeBy, contactMadeDate, email1, idmessages, message, preferredName, subject FROM messages;";
		
	//LOGIN
	public static final String LOGINFORMINSERTSQL = "INSERT INTO logins (userID, _createdAt) VALUES (?, CURRENT_TIMESTAMP)";
	public static final String LOGINFORMVALIDATESQL = "SELECT email from users where email = ?";
	public static final String USEREXISTSSQL = "SELECT statusID, salt, password FROM sponsors a, passwords b where a.sponsorID=b.userID and email = ?";
	public static final String FAILEDLOGIN = "Login failed for user ";
	public static final String FAILEDLOGININACTIVEMMESSAGE = " your login attempt was unsuccessful, your account is currently inactive. " + CONTACTUSDIRECTLYMESSAGE;
	public static final String FAILEDLOGINUSERNOTFOUNDMMESSAGE = " your login attempt was unsuccessful, your account was not found. Please request a PIN to register an account. " + CONTACTUSDIRECTLYMESSAGE;
	public static final String FAILEDLOGINPSSDMISMATCHMMESSAGE = " your login attempt was unsuccessful, your password did not match. " + CONTACTUSDIRECTLYMESSAGE;
	public static final String FAILEDLOGINSYSTEMMESSAGE = " your login attempt was unsuccessful, possibly a system problem. " + CONTACTUSDIRECTLYMESSAGE;
	public static final String SUCESSMESSAGE = "";

	// PASSWORDS
	public static final String REGISTERPASSWORDINSERTSQL = "INSERT INTO passwords (userID, password, _updatedDate, _createdDate) VALUES (? ,? , CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
	
	// REGISTER SPONSOR
	public static final String REGISTERSPONSORSQL = "INSERT INTO sponsors (statusID, roleID, permissionID, firstName, lastName, company, phoneNumber, email, address, city, state, zipCode, salt, securityQuestion, securityAnswer, _updatedAt, _createdAt) " +
			"	VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";
	
	// USER
	public static final String USERTYPESELECTSQL = "SELECT roleID, role FROM roles where roleID=? order by role";
	public static final String REGISTERINSERTSQL = "INSERT INTO users (permissionID, roleID, statusID, email, password, salt, _createdAt, _lastUpdateAt) VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
	
	// MESSAGES
	public static final String FAILEDXMLMESSAGE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><status value=\"Update was failed!\"></status>";
	public static final String SUCCESSXMLMESSAGE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><status value=\"Update was Successful!\"></status>";
	
	// LOGGING
	public static final String STARS = "***";
	public static final String DASH = "---";
	
	//MAIL
	public static final String PINMSGSUBJECT = "Entry Guard PIN Request";
	public static final String REGMSGSUBJECT = "Entry Guard Registration Complete";
	public static final String ADDUSERSUBJECT = "Entry Guard New User Added";
	public static final String USERLOOKEDUPSUBJECT = "Entry Guard User Lookup";
	public static final String SPONSORUPSUBJECT = "Entry Guard Sponsor Account Update";
	public static final String PINMSGBODY = "PIN Request From ";
	public static final String ENTRYGUARDHOST = "localhost";
	public static final String WEBMASTERMAILBOX = "webmaster@entry-guard.com";
	public static final String PINEMAILBOX = "pins@entry-guard.com";
	public static final String MESSAGESEMAILBOX = "messages@entry-guard.com";
	public static final String SUPERIORMAILBOX = "superior@entry-guard.com";
	public static final String SUPPORTMAILBOX = "support@entry-guard.com";	
	
	//ADMINISTRATION
	public static final String ADMINUSERSQL = "SELECT sponsorID, firstName, lastName, company, phoneNumber, email, address, city, state, zipCode, securityQuestion, securityAnswer, _updatedAt, _createdAt FROM sponsors where email=?";
	
	//ALL USERS
	public static final String ALLUSERSQL = "SELECT a.userID, a.firstName, a.lastName FROM users a, sponsors c where a.sponsorID=c.sponsorID and c.company = ?";
	public static final String USERSQL = "SELECT a.userID, a.statusID, b.statusName, a.firstName, a.lastName, a.phoneNumber, a.email, a.license, a.notes, a.photograph, a._createdAt FROM users a, status b, where a.statusID=b.statusID and a.userID = ?";
//	public static final String ALLUSERSQL = "SELECT a.userID, a.statusID, b.statusName, a.firstName, a.lastName, a.phoneNumber, a.email, a.license, a.notes, a.photograph, a._createdAt FROM users a, status b, sponsors c where a.statusID=b.statusID and a.sponsorID=c.sponsorID and c.company = ?";

	public static final String ALLUSERSQLB = "SELECT photograph FROM photographs c where userID=?";
	
	//EDIT USER
	public static final String EDITUSERSQL = "SELECT a.userID, a.statusID, b.statusName, a.firstName, a.lastName, a.phoneNumber, a.email, a.license, a.notes, a.photograph, c.company, c.email as sponsorEmail, a._createdAt, a._updatedAt FROM users a, status b, sponsors c where a.statusID=b.statusID and a.sponsorID=c.sponsorID and a.userID=?";
	public static final String UPDATEUSERFNSQL = "UPDATE users SET firstName = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE userID = ?";
	public static final String UPDATEUSERLNSQL = "UPDATE users SET lastName = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE userID = ?";
	public static final String UPDATEUSERPNSQL = "UPDATE users SET phoneNumber = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE userID = ?";
	public static final String UPDATEUSERNSQL = "UPDATE users SET notes = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE userID = ?";
	public static final String UPDATEUSEREMAILSQL = "UPDATE users SET email = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE userID = ?";
	public static final String UPDATEUSERPICTURESQL = "UPDATE users SET photograph = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE userID = ?";
	public static final String INSERTUSERCLASSSQL = "INSERT INTO userClassifications (userID, classID) VALUES (?, ?)";
	public static final String DELETEUSERCLASSSQL = "DELETE FROM userClassifications WHERE classID = ? and userID = ?";
	
	//EDIT SPONSOR
	public static final String UPDATESPONSORFNSQL = "UPDATE sponsors SET firstName = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE sponsorID = ?";
	public static final String UPDATESPONSORLNSQL = "UPDATE sponsors SET lastName = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE sponsorID = ?";
	public static final String UPDATESPONSORASQL = "UPDATE sponsors SET address = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE sponsorID = ?";
	public static final String UPDATESPONSORCSQL = "UPDATE sponsors SET city = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE sponsorID = ?";
	public static final String UPDATESPONSORSSQL = "UPDATE sponsors SET state = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE sponsorID = ?";
	public static final String UPDATESPONSORZCSQL = "UPDATE sponsors SET zipCode = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE sponsorID = ?";
	public static final String UPDATESPONSORPNSQL = "UPDATE sponsors SET phoneNumber = ?, _updatedAt = CURRENT_TIMESTAMP  WHERE sponsorID = ?";
	
	//USER LOOKUP
	public static final String USERLOOKUPSQL = "SELECT a.userID, a.firstName, a.lastName, a.phoneNumber, a.email, a.license, a.notes, a.qrCode, a.photograph, b.company, b.email as sponsorEmail, a._createdAt, a._updatedAt FROM users a, sponsors b where a.email=?";
	public static final String USERCLASSLOOKUPSQL = "SELECT a.className FROM  classifications a, userClassifications b where a.classID=b.classID and userID=? order by a.classID";
	
	//ADD USER
	public static final String REGISTERINITIALSQL = "INSERT INTO USERS (STATUSID, ROLEID, PERMISSIONID, SPONSORID, FIRSTNAME, LASTNAME, PHONENUMBER, COMPANY, EMAIL, _UPDATEDAT, _CREATEDAT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
	public static final String USERADDSQL = "INSERT INTO users (statusID, roleID, permissionID, firstName, lastName, phoneNumber, email, license, notes, _updatedAt, _createdAt, qrCode, sponsorID, photograph) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, ?, ?, ?)";
	public static final String USERADDCLASSIFICATIONSQL = "INSERT INTO `khzrfjky_entryguard`.`userClassifications` (`userID`, `classID`) VALUES (?, ?);";
	public static final String USERUPDATESQL = "UPDATE users SET statusID = ?, _updatedAt = CURRENT_TIMESTAMP, WHERE userID = ?;)";
	public static final String SUCCESSADDNERUSERMESSAGE = " was successfully created.";
	public static final String FAILUREADDNERUSERMESSAGE = "We were not able to create a new user account for ";
	public static final String DUPLICATEUSERMESSAGE1 = "The user ";
	public static final String DUPLICATEUSERMESSAGE2 = " already has an account. If you feel this message is in error";
	
//	//QR CODES
//	public static final String QRINSERTSQL = "INSERT INTO qrcodes (userID, qrCode, _updatedAt, _createdAt) VALUES (?,?,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
//	
//	//PICTURE
//	public static final String PHOTOINSERTSQL = "INSERT INTO photographs (userID, photograph, _updatedAt, _createdAt) VALUES (?,?,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
	public static final String PHOTOUPDATESQL = "INSERT INTO photographs (userID, photograph, _updatedAt, _createdAt) VALUES (?,?,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
	
	//DELETE USER
	public static final String SOFTDELETEUSER = "UPDATE users SET statusID = ?, _inactivatedAt = CURRENT_TIMESTAMP  WHERE userID = ?";
	public static final String DELETEMESSAGEA = "The account for ";
	public static final String SUCCESSDELETEMESSAGEB = " was successfully deleted.";
	public static final String FAILEDDELETEMESSAGEA = " was not deleted. There may have been a system issue." + CONTACTUSDIRECTLYMESSAGE;
	
	
	//SYSTEM CONSTANTS
	int SUCCESS = 10;
	int DUPLICATEEXISTS = 20;
	int SYSTEMISSUE = 30;
	int MAILSYSTEMISSUE = 31;
	int NOPINREQUESTED = 40;
	int PASSWORDMISMATCH = 50;
	
	//USER STATUS
	int ACTIVE = 10;
	int INACTIVE = 20;
	int NOACCOUNT = 30;
	
	//USER ROLES
	int SPONSOR = 10;
	int ADMIN = 20;
	int WORKER = 30;

	//USER PERMISSIONS
	int READWRITE = 10;
	int READONLY = 20;
	
	//QRCODE
	String QRURL = "http://entry-guard.com/service/userlookup?email=";
}
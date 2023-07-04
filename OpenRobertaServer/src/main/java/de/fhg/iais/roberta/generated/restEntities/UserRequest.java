/*
 * This is a class GENERATED by the TransportGenerator maven plugin. DON'T MODIFY IT.
 * IF you modify it, your work may be lost: the class will be overwritten automatically
 * when the maven plugin is re-executed for any reasons.
 */
package de.fhg.iais.roberta.generated.restEntities;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * the request description for the /createUser and /updateUser REST request<br><br>
 * Version: 1<br>
 * Datum: 2020-06-15
 */
public class UserRequest extends BaseRequest {
    protected String accountName;
    protected String password;
    protected String userEmail;
    protected String userName;
    protected String role;
    protected String language;
    protected boolean isYoungerThen14;
    protected boolean isYoungerThen14Defined = false;

    /**
     * the request description for the /createUser and /updateUser REST request
     */
    public static UserRequest make() {
        return new UserRequest();
    }

    /**
     * the request description for the /createUser and /updateUser REST request
     */
    public static UserRequest makeFromString(String jsonS) {
        try {
            JSONObject jsonO = new JSONObject(jsonS);
            return make(jsonO);
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON parse error when parsing: " + jsonS, e);
        }
    }

    /**
     * the request description for the /createUser and /updateUser REST request
     */
    public static UserRequest makeFromProperties(
        String cmd,
        String accountName,
        String password,
        String userEmail,
        String userName,
        String role,
        String language,
        boolean isYoungerThen14) {
        UserRequest entity = new UserRequest();
        entity.setCmd(cmd);
        entity.setAccountName(accountName);
        entity.setPassword(password);
        entity.setUserEmail(userEmail);
        entity.setUserName(userName);
        entity.setRole(role);
        entity.setLanguage(language);
        entity.setIsYoungerThen14(isYoungerThen14);
        entity.immutable();
        return entity;
    }

    /**
     * the request description for the /createUser and /updateUser REST request
     */
    public static UserRequest make(JSONObject jsonO) {
        return make().merge(jsonO).immutable();
    }

    /**
     * merge the properties of a JSON-object into this bean. The bean must be "under construction".
     * The keys of the JSON-Object must be valid. The bean remains "under construction".<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    public UserRequest merge(JSONObject jsonO) {
        try {
            for ( String key : JSONObject.getNames(jsonO) ) {
                if ( "_version".equals(key) ) {
                } else if ( "cmd".equals(key) ) {
                    setCmd(jsonO.optString(key));
                } else if ( "accountName".equals(key) ) {
                    setAccountName(jsonO.getString(key));
                } else if ( "password".equals(key) ) {
                    setPassword(jsonO.optString(key));
                } else if ( "userEmail".equals(key) ) {
                    setUserEmail(jsonO.getString(key));
                } else if ( "userName".equals(key) ) {
                    setUserName(jsonO.getString(key));
                } else if ( "role".equals(key) ) {
                    setRole(jsonO.getString(key));
                } else if ( "language".equals(key) ) {
                    setLanguage(jsonO.getString(key));
                } else if ( "isYoungerThen14".equals(key) ) {
                    setIsYoungerThen14(jsonO.getBoolean(key));
                } else {
                    throw new RuntimeException("JSON parse error. Found invalid key: " + key + " in " + jsonO);
                }
            }
            return this;
        } catch ( Exception e ) {
            throw new RuntimeException("JSON parse / casting error when parsing: " + jsonO, e);
        }
    }

    /**
     * moves a bean from state "under construction" to state "immutable".<br>
     * Checks whether all required fields are set. All lists are made immutable.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    public UserRequest immutable() {
        if ( this.immutable ) {
            return this;
        }
        this.immutable = true;
        return validate();
    }

    /**
     * Checks whether all required fields are set.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    private UserRequest validate() {
        String _message = null;
        if ( !this.immutable ) {
            _message = "UserRequest-object is already immutable: " + toString();
        }
        if ( accountName == null ) {
            _message = "required property accountName of UserRequest-object is not set: " + toString();
        }
        if ( userEmail == null ) {
            _message = "required property userEmail of UserRequest-object is not set: " + toString();
        }
        if ( userName == null ) {
            _message = "required property userName of UserRequest-object is not set: " + toString();
        }
        if ( role == null ) {
            _message = "required property role of UserRequest-object is not set: " + toString();
        }
        if ( language == null ) {
            _message = "required property language of UserRequest-object is not set: " + toString();
        }
        if ( !isYoungerThen14Defined ) {
            _message = "required property isYoungerThen14 of UserRequest-object is not set: " + toString();
        }
        if ( _message != null ) {
            this.immutable = false;
            throw new RuntimeException(_message);
        }
        return this;
    }

    /**
     * GET accountName. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getAccountName() {
        if ( !this.immutable ) {
            throw new RuntimeException("no accountName from an object under construction: " + toString());
        }
        return this.accountName;
    }

    /**
     * SET accountName. Object must be mutable.
     */
    public UserRequest setAccountName(String accountName) {
        if ( this.immutable ) {
            throw new RuntimeException("accountName assigned to an immutable object: " + toString());
        }
        this.accountName = accountName;
        return this;
    }

    /**
     * GET password. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getPassword() {
        if ( !this.immutable ) {
            throw new RuntimeException("no password from an object under construction: " + toString());
        }
        return this.password;
    }

    /**
     * is the property defined? The property maybe undefined as it is not a required property
     *
     * @return true if the property is defined (has been set)
     */
    public boolean passwordDefined() {
        return this.password != null;
    }

    /**
     * SET password. Object must be mutable.
     */
    public UserRequest setPassword(String password) {
        if ( this.immutable ) {
            throw new RuntimeException("password assigned to an immutable object: " + toString());
        }
        this.password = password;
        return this;
    }

    /**
     * GET userEmail. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getUserEmail() {
        if ( !this.immutable ) {
            throw new RuntimeException("no userEmail from an object under construction: " + toString());
        }
        return this.userEmail;
    }

    /**
     * SET userEmail. Object must be mutable.
     */
    public UserRequest setUserEmail(String userEmail) {
        if ( this.immutable ) {
            throw new RuntimeException("userEmail assigned to an immutable object: " + toString());
        }
        this.userEmail = userEmail;
        return this;
    }

    /**
     * GET userName. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getUserName() {
        if ( !this.immutable ) {
            throw new RuntimeException("no userName from an object under construction: " + toString());
        }
        return this.userName;
    }

    /**
     * SET userName. Object must be mutable.
     */
    public UserRequest setUserName(String userName) {
        if ( this.immutable ) {
            throw new RuntimeException("userName assigned to an immutable object: " + toString());
        }
        this.userName = userName;
        return this;
    }

    /**
     * GET role. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getRole() {
        if ( !this.immutable ) {
            throw new RuntimeException("no role from an object under construction: " + toString());
        }
        return this.role;
    }

    /**
     * SET role. Object must be mutable.
     */
    public UserRequest setRole(String role) {
        if ( this.immutable ) {
            throw new RuntimeException("role assigned to an immutable object: " + toString());
        }
        this.role = role;
        return this;
    }

    /**
     * GET language. Object must be immutable. Never return null or an undefined/default value.
     */
    public String getLanguage() {
        if ( !this.immutable ) {
            throw new RuntimeException("no language from an object under construction: " + toString());
        }
        return this.language;
    }

    /**
     * SET language. Object must be mutable.
     */
    public UserRequest setLanguage(String language) {
        if ( this.immutable ) {
            throw new RuntimeException("language assigned to an immutable object: " + toString());
        }
        this.language = language;
        return this;
    }

    /**
     * GET isYoungerThen14. Object must be immutable. Never return null or an undefined/default value.
     */
    public boolean getIsYoungerThen14() {
        if ( !this.immutable ) {
            throw new RuntimeException("no isYoungerThen14 from an object under construction: " + toString());
        }
        return this.isYoungerThen14;
    }

    /**
     * SET isYoungerThen14. Object must be mutable.
     */
    public UserRequest setIsYoungerThen14(boolean isYoungerThen14) {
        if ( this.immutable ) {
            throw new RuntimeException("isYoungerThen14 assigned to an immutable object: " + toString());
        }
        this.isYoungerThen14 = isYoungerThen14;
        this.isYoungerThen14Defined = true;
        return this;
    }

    /**
     * generates a JSON-object from an immutable bean.<br>
     * Throws a runtime exception if inconsistencies are detected.
     */
    public JSONObject toJson() {
        if ( !this.immutable ) {
            throw new RuntimeException("no JSON from an object under construction: " + toString());
        }
        JSONObject jsonO = new JSONObject();
        try {
            jsonO.put("_version", "1");
            if ( this.cmd != null ) {
                jsonO.put("cmd", this.cmd);
            }
            jsonO.put("accountName", this.accountName);
            if ( this.password != null ) {
                jsonO.put("password", this.password);
            }
            jsonO.put("userEmail", this.userEmail);
            jsonO.put("userName", this.userName);
            jsonO.put("role", this.role);
            jsonO.put("language", this.language);
            jsonO.put("isYoungerThen14", this.isYoungerThen14);
        } catch ( JSONException e ) {
            throw new RuntimeException("JSON unparse error when unparsing: " + this, e);
        }
        return jsonO;
    }

    @Override
    public String toString() {
        return "UserRequest [immutable=" + this.immutable + ", cmd=" + this.cmd + ", accountName=" + this.accountName + ", password=" + this.password + ", userEmail=" + this.userEmail + ", userName=" + this.userName + ", role=" + this.role + ", language=" + this.language + ", isYoungerThen14=" + this.isYoungerThen14 + " ]";
    }

    @Override
    public int hashCode() {
        throw new RuntimeException("no hashCode from transport beans!");
    }

    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("no equals from transport beans!");
    }

}
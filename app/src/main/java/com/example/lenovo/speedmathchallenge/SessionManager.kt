package com.example.lenovo.speedmathchallenge

/**
 * Created by lenovo on 5/3/18.
 */


import java.util.HashMap
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import java.lang.reflect.Array.get

class SessionManager// Constructor
(// Context
    internal var _context: Context) {
    // Shared Preferences
    internal var pref: SharedPreferences

    // Editor for Shared preferences
    internal var editor: Editor

    // Shared pref mode
    internal var PRIVATE_MODE = 0


    /**
     * Get stored session data
     */
    // user name
    // user email id
    // return user
    val userDetails: HashMap<String, String>
        get() {
            val user = HashMap<String, String>()
            user[KEY_PHONE_NUMBER] = pref.getString(KEY_PHONE_NUMBER, null)
            user[KEY_PASSWORD] = pref.getString(KEY_PASSWORD, null)
            return user
        }

    /**
     * Quick check for login
     */
    // Get Login State
    val  isLoggedIn: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)


    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    /**
     * Create login session
     */
    fun createLoginSession(name: String, password: String) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true)

        // Storing name in pref
        editor.putString(KEY_PHONE_NUMBER, name)

        // Storing email in pref
        editor.putString(KEY_PASSWORD, password)

        // commit changes
        editor.commit()
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    fun checkLogin() {
        // Check login status
        if (!this.isLoggedIn) {
            // user is not logged in redirect him to Login Activity
            val i = Intent(_context, LoginActivity::class.java)
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

            // Add new Flag to start new Activity
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            // Staring Login Activity
            _context.startActivity(i)
        }

    }

    /**
     * Clear session details
     */
    fun logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear()
        editor.commit()

        // After logout redirect user to Loing Activity
        val i = Intent(_context, LoginActivity::class.java)
        // Closing all the Activities
        /*i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);*/

        // Staring Login Activity
        _context.startActivity(i)
    }

    companion object {

        // Sharedpref file name
        private val PREF_NAME = "AndroidHivePref"

        // All Shared Preferences Keys
        private val IS_LOGIN = "IsLoggedIn"

        // User name (make variable public to access from outside)
        val KEY_PHONE_NUMBER = "name"

        // Email address (make variable public to access from outside)
        val KEY_PASSWORD = "password"
    }
}





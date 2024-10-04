package com.fidelity.model;

 

import static org.junit.jupiter.api.Assertions.*;

 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fidelity.model.Preferences;
import com.fidelity.utils.PreferenceService;

 

public class PreferenceServiceTest {

 

    private PreferenceService preferenceService;

 

    @BeforeEach
    public void setUp() {
        preferenceService = new PreferenceService();
        preferenceService.UpdatePreferencess();
    }

 

    @Test
    public void testAddPreference() {
        Preferences preferences = new Preferences("Retirement", "Moderate", "High", "Long-term");
        preferenceService.addPreference(1, preferences);
        assertTrue(preferenceService.searchPreference(1, preferences));
    }

 

  

 

    @Test
    public void testSearchPreference() {
        Preferences preferences = new Preferences("Retirement", "Moderate", "High", "Long-term");
        assertFalse(preferenceService.searchPreference(1, preferences));

        preferenceService.addPreference(1, preferences);
        assertTrue(preferenceService.searchPreference(1, preferences));
    }

 

    @Test
    public void testUpdatePreference() {
        Preferences preferences1 = new Preferences("Retirement", "Moderate", "High", "Long-term");
        Preferences preferences2 = new Preferences("Education", "Aggressive", "Low", "Short-term");

        preferenceService.addPreference(1, preferences1);
        assertTrue(preferenceService.updatePreference(1, preferences1, preferences2));
        assertTrue(preferenceService.searchPreference(1, preferences2));
        assertFalse(preferenceService.searchPreference(1, preferences1));
    }

 

    @Test
    public void testUpdateNonexistentPreference() {
        Preferences preferences1 = new Preferences("Retirement", "Moderate", "High", "Long-term");
        Preferences preferences2 = new Preferences("Education", "Aggressive", "Low", "Short-term");

        assertFalse(preferenceService.updatePreference(1, preferences1, preferences2));
    }
}
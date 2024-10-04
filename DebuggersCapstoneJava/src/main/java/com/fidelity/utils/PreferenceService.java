package com.fidelity.utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fidelity.model.Preferences;

 

public class PreferenceService {
    private Map<Integer, List<Preferences>> PreferencesMap;

 

    public void UpdatePreferencess() {
        this.PreferencesMap = new HashMap<>();
    }

 

    public void addPreference(int clientId, Preferences cpNew) {
        if (!PreferencesMap.containsKey(clientId)) {
            PreferencesMap.put(clientId, new ArrayList<>());
        }
        List<Preferences> Preferencess = PreferencesMap.get(clientId);

        for (Preferences cp : Preferencess) {
            if (cp.equals(cpNew)) {
                throw new IllegalArgumentException("Duplicate Preference detected for client " + clientId + "!");
            }
        }
        Preferencess.add(cpNew);
    }

 

    public boolean searchPreference(int clientId, Preferences cpNew) {
        if (PreferencesMap.containsKey(clientId)) {
            List<Preferences> Preferencess = PreferencesMap.get(clientId);
            for (Preferences cp : Preferencess) {
                if (cp.equals(cpNew)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean updatePreference(int clientId, Preferences cpExisting, Preferences cpUpdated) {
        if (PreferencesMap.containsKey(clientId)) {
            List<Preferences> Preferencess = PreferencesMap.get(clientId);
            for (Preferences cp : Preferencess) {
                if (cp.equals(cpExisting)) {
                	Preferencess.remove(cpExisting);
                	Preferencess.add(cpUpdated);
                    return true;
                }
            }
        }
        return false; 
    }
}
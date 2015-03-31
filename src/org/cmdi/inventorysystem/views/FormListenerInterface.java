/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cmdi.inventorysystem.views;

import java.util.EventListener;

/**
 *
 * @author Zremud
 */
public interface FormListenerInterface extends EventListener{
    public void formEventOccured(EventInterface e);
}

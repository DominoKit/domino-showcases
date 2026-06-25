package org.dominokit.pages.presenters.samples;

import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import dominojackson.shaded.com.google.auto.service.AutoService;
import elemental2.dom.DomGlobal;
import org.dominokit.brix.api.BrixStartupTask;
import org.dominokit.showcases.samples.model.Contact;
import org.dominokit.showcases.samples.model.ContactList;
import org.dominokit.showcases.samples.model.ContactsProvider;

import java.util.List;

@AutoService(BrixStartupTask.class)
public class LoadContactsStartupTask extends BrixStartupTask {
    @Override
    public int order() {
        return 0;
    }

    @Override
    public void run() {
        try {
            JsonResource.INSTANCE.generatedJson().getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load json", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    ContactList contactList = ContactList.MAPPER.read(resource.getText());

                    List<Contact> contacts = contactList.getContacts();
                    ContactsProvider.setContacts(contacts);
                    complete();
                }
            });
        } catch (ResourceException e) {
            complete();
        }
    }
}

package org.dominokit.pages.presenters;


import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.ListenFor;
import org.dominokit.brix.annotations.OnReveal;
import org.dominokit.brix.api.Presenter;
import org.dominokit.pages.shared.events.ContentState;
import org.dominokit.pages.views.SampleView;

@BrixSlot("dui-demo-sample-slot")
public abstract class SampleProxy extends Presenter<SampleView> implements SampleView.SampleUiHandlers {

    @ListenFor(ContentState.class)
    public void onContentReady(ContentState event){
        reveal();
    }

    @OnReveal
    public void renderSamples(){
        view.renderSamples();
    }
}

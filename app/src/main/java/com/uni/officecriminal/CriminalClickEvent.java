package com.uni.officecriminal;

import com.uni.officecriminal.model.Criminal;

class CriminalClickEvent {
    private Criminal criminal;

    public CriminalClickEvent(Criminal criminal) {
        this.criminal = criminal;
    }

    public Criminal getCriminal() {
        return criminal;
    }
}

package com.actorvoice.connection;
/**
 Copyright (c) 2015, James Bond
 All rights reserved.

 Redistribution and use in source and binary forms, with or without modification,
 are permitted provided that the following conditions are met:

 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import org.json.JSONObject;


public interface StreamDescriptionInterface {
    /** stream states - mostly remote stuff, or local */
    public enum StreamState {
        UNKNOWN, OPENING, ACTIVE, CLOSING, DESTROYED, LOCAL, BLOCKED,
    }

    public abstract JSONObject toJson();

    /** access this streams unique id */
    public abstract String getId();

    /** new id */
    public abstract void setId(String newId);

    /** check if this is outgoing (local, true), or incoming (remote, false) */
    public abstract boolean isLocal();

    /** generate an offer json object - with given state value */
    public abstract JSONObject toJsonOffer(String state);

    /** detach a previously attached renderer */
    public abstract void detachRenderer();

    /** server signaled end of stream - should no longer be interesting */
    public abstract void onClosing();

    /** local controller instance removed this stream - MUST NOT be used anymore */
    public abstract void onDestroyed();

    /** disable/block a stream, can later be subscribed again */
    public abstract void onDisable();

    /** retrieve current state of this stream */
    public abstract StreamState getState();

    /** toggles audio between active and mute */
    public abstract void toggleAudio();

    /** sets the audio allowed state - audio plays, or audio is muted */
    public abstract void setAudioActive(boolean audioActive);

    /** checks if audio for this stream is currently playing, or muted */
    public abstract boolean isAudioActive();

    /** retrieve the nick associated with this stream - may return null */
    public abstract String getNick();
}

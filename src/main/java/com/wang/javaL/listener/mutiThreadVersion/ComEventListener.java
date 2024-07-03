package com.wang.javaL.listener.mutiThreadVersion;

import java.util.EventListener;
import java.util.concurrent.Callable;

public interface ComEventListener extends EventListener,Callable<String> {
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Condition;
import org.eclipse.xtext.web.example.statemachine.statemachine.Event;
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
import org.eclipse.xtext.web.example.statemachine.statemachine.State;
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine;
import org.eclipse.xtext.web.example.statemachine.statemachine.Transition;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StatemachineFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private StatemachineGrammarAccess _statemachineGrammarAccess;
  
  protected void _format(final Statemachine statemachine, @Extension final IFormattableDocument document) {
    EList<Signal> _signals = statemachine.getSignals();
    for (final Signal signal : _signals) {
      {
        this.format(signal, document);
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.setNewLines(1, 1, 2);
        };
        document.<Signal>append(signal, _function);
      }
    }
    EList<State> _states = statemachine.getStates();
    for (final State state : _states) {
      {
        this.format(state, document);
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.setNewLines(1, 1, 2);
        };
        document.<State>append(state, _function);
      }
    }
  }
  
  protected void _format(final Signal signal, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(signal);
    StatemachineGrammarAccess.SignalElements _signalAccess = this._statemachineGrammarAccess.getSignalAccess();
    Keyword _signalKeyword_1 = _signalAccess.getSignalKeyword_1();
    ISemanticRegion _keyword = _regionFor.keyword(_signalKeyword_1);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    ISemanticRegion _prepend = document.prepend(_keyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_prepend, _function_1);
  }
  
  protected void _format(final State state, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(state);
    StatemachineGrammarAccess.StateElements _stateAccess = this._statemachineGrammarAccess.getStateAccess();
    Keyword _stateKeyword_0 = _stateAccess.getStateKeyword_0();
    ISemanticRegion _keyword = _regionFor.keyword(_stateKeyword_0);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(
      document.append(this.textRegionExtensions.regionFor(state).assignment(this._statemachineGrammarAccess.getStateAccess().getNameAssignment_1()), ((Procedure1<IHiddenRegionFormatter>) (IHiddenRegionFormatter it) -> {
        it.newLine();
      })), 
      this.textRegionExtensions.regionFor(state).keyword(this._statemachineGrammarAccess.getStateAccess().getEndKeyword_5()), _function_1);
    EList<Command> _commands = state.getCommands();
    for (final Command command : _commands) {
      {
        this.format(command, document);
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.<Command>append(command, _function_2);
      }
    }
    EList<Transition> _transitions = state.getTransitions();
    for (final Transition transition : _transitions) {
      {
        this.format(transition, document);
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.<Transition>append(transition, _function_2);
      }
    }
    EList<State> _nestedStates = state.getNestedStates();
    for (final State nestedState : _nestedStates) {
      {
        this.format(nestedState, document);
        final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.<State>append(nestedState, _function_2);
      }
    }
  }
  
  protected void _format(final Command command, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(command);
    StatemachineGrammarAccess.CommandElements _commandAccess = this._statemachineGrammarAccess.getCommandAccess();
    Keyword _setKeyword_0 = _commandAccess.getSetKeyword_0();
    ISemanticRegion _keyword = _regionFor.keyword(_setKeyword_0);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(command);
    StatemachineGrammarAccess.CommandElements _commandAccess_1 = this._statemachineGrammarAccess.getCommandAccess();
    Keyword _equalsSignKeyword_2 = _commandAccess_1.getEqualsSignKeyword_2();
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(_equalsSignKeyword_2);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    ISemanticRegion _prepend = document.prepend(_keyword_1, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_prepend, _function_2);
  }
  
  protected void _format(final Transition transition, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(transition);
    StatemachineGrammarAccess.TransitionElements _transitionAccess = this._statemachineGrammarAccess.getTransitionAccess();
    Keyword _ifKeyword_0 = _transitionAccess.getIfKeyword_0();
    ISemanticRegion _keyword = _regionFor.keyword(_ifKeyword_0);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_keyword, _function);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(transition);
    StatemachineGrammarAccess.TransitionElements _transitionAccess_1 = this._statemachineGrammarAccess.getTransitionAccess();
    Keyword _gotoKeyword_2 = _transitionAccess_1.getGotoKeyword_2();
    ISemanticRegion _keyword_1 = _regionFor_1.keyword(_gotoKeyword_2);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    ISemanticRegion _prepend = document.prepend(_keyword_1, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_prepend, _function_2);
    Condition _condition = transition.getCondition();
    boolean _tripleNotEquals = (_condition != null);
    if (_tripleNotEquals) {
      this.format(transition.getCondition(), document);
    }
  }
  
  protected void _format(final Condition condition, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(condition);
    StatemachineGrammarAccess.ConditionElements _conditionAccess = this._statemachineGrammarAccess.getConditionAccess();
    Keyword _andKeyword_1_0 = _conditionAccess.getAndKeyword_1_0();
    List<ISemanticRegion> _keywords = _regionFor.keywords(_andKeyword_1_0);
    final Consumer<ISemanticRegion> _function = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      ISemanticRegion _prepend = document.prepend(it, _function_1);
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.append(_prepend, _function_2);
    };
    _keywords.forEach(_function);
    EList<Event> _events = condition.getEvents();
    for (final Event event : _events) {
      this.format(event, document);
    }
  }
  
  protected void _format(final Event event, @Extension final IFormattableDocument document) {
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(event);
    StatemachineGrammarAccess.EventElements _eventAccess = this._statemachineGrammarAccess.getEventAccess();
    Keyword _equalsSignEqualsSignKeyword_1 = _eventAccess.getEqualsSignEqualsSignKeyword_1();
    ISemanticRegion _keyword = _regionFor.keyword(_equalsSignEqualsSignKeyword_1);
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    ISemanticRegion _prepend = document.prepend(_keyword, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(_prepend, _function_1);
  }
  
  public void format(final Object command, final IFormattableDocument document) {
    if (command instanceof XtextResource) {
      _format((XtextResource)command, document);
      return;
    } else if (command instanceof Command) {
      _format((Command)command, document);
      return;
    } else if (command instanceof Condition) {
      _format((Condition)command, document);
      return;
    } else if (command instanceof Event) {
      _format((Event)command, document);
      return;
    } else if (command instanceof Signal) {
      _format((Signal)command, document);
      return;
    } else if (command instanceof State) {
      _format((State)command, document);
      return;
    } else if (command instanceof Statemachine) {
      _format((Statemachine)command, document);
      return;
    } else if (command instanceof Transition) {
      _format((Transition)command, document);
      return;
    } else if (command instanceof EObject) {
      _format((EObject)command, document);
      return;
    } else if (command == null) {
      _format((Void)null, document);
      return;
    } else if (command != null) {
      _format(command, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(command, document).toString());
    }
  }
}

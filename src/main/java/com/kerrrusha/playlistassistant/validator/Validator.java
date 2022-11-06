package com.kerrrusha.playlistassistant.validator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.TreeSet;

import static java.util.stream.Collectors.toCollection;

public abstract class Validator {

	private final Collection<Optional<String>> possibleErrors;

	public Validator() {
		possibleErrors = new HashSet<>();
	}

	protected abstract void validate();

	public final Collection<String> getErrors() {
		clearPossibleErrors();
		validate();
		return possibleErrors.stream()
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(toCollection(TreeSet<String>::new));
	}

	public final void clearPossibleErrors() {
		possibleErrors.clear();
	}

	public final void addPossibleError(Optional<String> error) {
		possibleErrors.add(error);
	}
}

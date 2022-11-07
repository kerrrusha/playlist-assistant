package com.kerrrusha.playlistassistant.validator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import static java.util.stream.Collectors.toCollection;

public abstract class AbstractValidator {

	private final Collection<Optional<String>> possibleErrors;

	public AbstractValidator() {
		possibleErrors = new HashSet<>();
	}

	protected abstract void validate();

	public abstract Collection<String> getErrors();

	protected final Collection<String> getErrorPool() {
		return possibleErrors.stream()
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(toCollection(HashSet<String>::new));
	}

	protected final void clearPossibleErrors() {
		possibleErrors.clear();
	}

	protected final void addPossibleError(Optional<String> error) {
		possibleErrors.add(error);
	}
}

package org.kohsuke.github;

import com.infradna.tool.bridge_method_injector.WithBridgeMethods;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * The response that is returned when updating repository content.
 */
public class GHContentUpdateResponse {
    private GHContent content;
    private GitCommit commit;

    /**
     * Gets content.
     *
     * @return the content
     */
    @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
    public GHContent getContent() {
        return content;
    }

    /**
     * Gets commit.
     *
     * @return the commit
     */
    @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
    @WithBridgeMethods(value = GHCommit.class, adapterMethod = "castToGHCommit")
    public GitCommit getCommit() {
        return commit;
    }

    private GHCommit castToGHCommit(GitCommit commit, Class targetType) {
        // if (targetType == GHCommit.class) {
        return new GHCommit(commit.getOwner(), commit.getCommitShortInfo());
    }

}

package org.dominokit.showcases.samples.components.markdown;

final class MarkdownSamples {

    private MarkdownSamples() {}

    static String editor() {
        return """
            # Standalone editor

            This editor surface is intentionally preview-free.

            ## Try commands
            - bold
            - italic
            - heading
            - link
            - image
            - code block

            > The toolbar and dialogs still come from the real editor implementation.

            ```java
            MarkdownEditor editor = MarkdownEditor.from(MarkdownEditorConfig.builder().build());
            editor.setToolbarEnabled(true);
            editor.setLivePreview(false);
            ```
            """.trim();
    }

    static String preview() {
        return """
            # Standalone preview

            MarkdownPreview is useful when markdown is coming from somewhere else.

            ## Features shown here
            - headings
            - lists
            - block quotes
            - code blocks
            - tables

            | Column | Value |
            | --- | --- |
            | One | Ready |
            | Two | Live |

            ```js
            console.log("preview");
            ```
            """.trim();
    }

    static String previewTwo() {
        return """
            # Another preview sample

            The preview component can be switched between source documents without rebuilding the page.

            1. Update markdown
            2. Re-render
            3. Inspect the HTML output

            > This tab makes it easy to verify renderer and sanitizer wiring.
            """.trim();
    }

    static String split() {
        return """
            # Split editor

            This content is intentionally long enough to exercise scrolling in both panes.

            ## Section 1
            The split editor wraps the standalone editor and preview together.

            ## Section 2
            Use edit-only, preview-only, and split modes to verify layout changes.

            ## Section 3
            Scroll sync stays aligned when the editor and preview share the same source.

            ## Section 4
            Keep adding paragraphs until the split layout has to manage overflow.

            ## Section 5
            - one
            - two
            - three
            - four
            - five
            - six
            - seven
            """.trim();
    }

    static String binding() {
        return """
            # Binding demo

            The editor binds to a preview that can live anywhere in the page tree.

            ## Why it matters
            - editor and preview do not need to sit next to each other
            - you can rebind the editor to another preview at runtime
            - the binding works with live preview and scroll sync

            ### A
            First block.

            ### B
            Second block.

            ### C
            Third block.

            ### D
            Fourth block.
            """.trim();
    }

    static String playground() {
        return """
            # Playground

            This sample keeps the editor and preview in the same card while the controls stay close by.

            ## What to test
            - debounce changes
            - renderer swaps
            - sanitizer swaps
            - live preview toggles
            - scroll sync toggles

            ```java
            editor.bindPreview(preview);
            editor.setSyncScrollEnabled(true);
            editor.setRenderDebounceMillis(150);
            ```
            """.trim();
    }

    static String classStyling() {
        return """
            # Class styling extension

            The same markdown is rendered twice so you can compare the default output with a renderer that injects CSS hooks.

            > The extension keeps the markdown structure intact and only adds classes at render time.

            ## Why it is useful
            - style generated markdown without mutating the source
            - target HTML output with predictable classes
            - reuse the same extension across HTML and DOM renderers

            Here is `inline code`, **strong text**, and a [link](https://dominokit.com).

            ```java
            MarkdownClassExtension demoClasses =
                MarkdownClassExtension.builder()
                    .classes("demo-md")
                    .nodeClasses(Heading.class, "demo-md-heading")
                    .tagClasses("h1", "demo-md-h1")
                    .build();
            ```
            """.trim();
    }
}

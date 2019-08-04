const COMMENT = (function () {
    'use strict';

    const commentEditTemplate =
        "<div class=\"add-comment\">" +
        "<input id=\"{{contentsId}}\" name=\"contents\" type=\"hidden\">" +
        "<div id=\"{{editorId}}\" class = \"comment-editor\"></div>" +
        "<input name=\"_method\" type=\"hidden\" value=\"put\"/>" +
        "<button class=\"btn btn-default\" id=\"{{buttonId}}\" >댓글 수정" +
        "</button>" + "</div>";

    const compiledCommentEditTemplate = Handlebars.compile(commentEditTemplate)


    const CommentController = function () {
        const commentService = new CommentService()

        const updateComment = function () {
            const comments = document.getElementById("comment-list")
            comments.addEventListener('click', commentService.update)
        }

        const init = function () {
            updateComment()
        }

        return {
            init: init
        }
    }

    const CommentService = function () {
        const update = function (event) {
            const target = event.target
            const parent = target.closest("li")
            const form = parent.getElementsByTagName("form")[0]
            if (target.classList.contains("comment-edit") &&
                (parent.getElementsByClassName("comment-editor").length === 0)) {
                const url = form.action
                const tokens = form.action.split('/')
                const commentId = tokens[tokens.length - 1]
                const editorId = "editSection" + commentId
                const contentsId = "comment-contents" + commentId
                const buttonId = "comment-edit-finish-button" + commentId

                parent.insertAdjacentHTML("beforeend",
                    compiledCommentEditTemplate({
                        "url": url,
                        "editorId": editorId,
                        "contentsId": contentsId,
                        "buttonId": buttonId
                    }))

                const editor2 = new tui.Editor({
                    el: document.querySelector('#' + editorId),
                    initialEditType: 'markdown',
                    previewStyle: 'horizontal',
                    events: {
                        change: function () {
                            document.getElementById(contentsId).setAttribute
                            ('value', editor2.getMarkdown())
                        }
                    },
                    height: '200px'
                });

                const button = document.getElementById(buttonId)
                button.addEventListener('click', function (event) {
                    let target = event.target
                    let parent = target.closest("li")
                    let form = parent.getElementsByTagName("form")[0]
                    let contents = document.getElementById(contentsId).value

                    let data = new FormData()
                    data.append('contents', contents)

                    fetch(form.action, {
                        method: 'PUT',
                        body: data
                    }).then(response => response.json())
                        .then((json) => json)
                        .catch(error => error)
                })
            }
        }

        return {
            update: update
        }
    }

    const init = function () {
        const commentController = new CommentController()
        commentController.init()
    }

    return {
        init: init
    }

})();
COMMENT.init();

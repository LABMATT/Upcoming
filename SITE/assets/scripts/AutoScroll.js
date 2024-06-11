// Functions to edit.
let autoScrollEnabled = false;

// Auto scrolls to bottom of page.
function autoScroll()
{

    if (autoScrollEnabled) {

        window.scroll(0, 0);

        setTimeout(scrollDown, 4000);
    }
}


// Scrolls down to bottom then pauses before reset.
function scrollDown() {

    console.log("pay6offset: " + window.pageYOffset);
    console.log("innerhight: " + window.scrollY);

    const scrolledTo = window.scrollY + window.innerHeight

    if (document.body.scrollHeight !== scrolledTo) {

        window.scrollBy(0, 1);
        setTimeout(scrollDown, 200);
    } else {

        setTimeout((scrollDown) => {
            window.scroll(0, 0);
        }, 4000);
    }

}

// Reg events on focus of page then scroll down.
function regFoucs() {

    window.addEventListener("focus", autoScroll);
    console.log("regedfocwsu");
}
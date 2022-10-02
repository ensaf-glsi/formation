import Profile from "./Avatar";

export function Gallery() {
    return (
        <section>
            <h1>Amazing scientists</h1>
            <Profile user={{image: "https://picsum.photos/300", name: "ahmed" }} className="avtar" online />
            <Profile user={{image: "https://picsum.photos/200", name: "najat" }} online={true} />
            <Profile user={{image: "https://picsum.photos/200", name: "malak" }} online={false} />
        </section>
    );
}
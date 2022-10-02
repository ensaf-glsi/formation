export default function Avatar({ user, online, className="profile" }) {
    console.log('user ? ', user);
    console.log('online ? ', online);
    console.log('className ? ', className);
    // console.log('props ? ', props);
    // const {user} = props; //<=> const user = props.user;
    return (
        <img
            src={user.image}
            alt={user.name}
        />
    );
}

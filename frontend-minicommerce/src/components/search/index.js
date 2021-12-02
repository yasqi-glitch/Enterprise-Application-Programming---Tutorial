import React from "react";

const Search = (props) => {
    const barStyling = {width: "100%", background: "#F2F1F9", padding: "0.5rem"};
    return (
        <input
            style={barStyling}
            type="search"
            placeholder={"Cari nama item"}
            onChange={props.handleChange}
        />
    );
}

export default Search;
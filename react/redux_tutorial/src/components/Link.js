import React, { PropTypes } from 'react'

const Link = ({ children, onClick }) => (
  <a href="#">{children}</a>
)

Link.propTypes = {
  children: PropTypes.node.isRequired
}

export default Link